package goit.hw7.model.jdbc;

import goit.hw7.model.DaoInterfaces.DishDao;
import goit.hw7.model.DaoInterfaces.EmployeeDao;
import goit.hw7.model.DaoInterfaces.OrderDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcOrderDao implements OrderDao { //TODO: upgrade working with status

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDao.class);
    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private Map<Integer, Boolean> ordersStatus = new HashMap<>();

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addOrder(Order order) {
        String query = "INSERT INTO ORD (ID, table_number, date, employee_id, dish_id)" +
                "VALUES (?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getId());
            statement.setInt(2, order.getTableNumber());
            statement.setDate(3, Date.valueOf(order.getDate()));
            statement.setInt(4, order.getEmployee().getId());
            statement.setInt(5, order.getDish().getId());

            statement.execute();
            if (!ordersStatus.containsKey(order.getId())) {
                ordersStatus.put(order.getId(), true);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot add new prepared dish in " + order.toString());
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Order getById(int id) {
        Order order = new Order();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM ord WHERE ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = createOrder(resultSet);
            }

            return order;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find employee with id: " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDish(Dish dish, int orderId) {

        if(ordersStatus.get(orderId)) {

            Order order = new Order();

            try(Connection connection = dataSource.getConnection();
                PreparedStatement getOrder = connection.prepareStatement("SELECT * FROM ord WHERE ID = ?")) {

                getOrder.setInt(1, orderId);
                ResultSet resultSet = getOrder.executeQuery();
                while (resultSet.next()) {
                    order = createOrder(resultSet);
                }
                order.setDish(dish);

                addOrder(order);

            } catch (SQLException e) {
                LOGGER.error("Exception occurred while connecting to DB ", e);
                throw new RuntimeException("Cannot add Dish: " + dish.toString());
            }

        } else if (ordersStatus.get(orderId) == null) {
            LOGGER.error("Can't get order status for order with id: " + orderId);
            throw new RuntimeException("Can't get order status");
        } else {
            LOGGER.info("Order with id " + orderId + " is closed");
        }


    }

    @Override
    public void deleteDish(Dish dish, int orderId) {
        if(ordersStatus.get(orderId)) {

            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM ord WHERE ID = ? AND dish_id = ?")) {

                statement.setInt(1, orderId);
                statement.setInt(2, dish.getId());
                statement.execute();

            } catch (SQLException e) {
                LOGGER.error("Exception occurred while connecting to DB ", e);
                throw new RuntimeException("Cannot delete Dish: " + dish.toString());
            }

        } else if (ordersStatus.get(orderId) == null) {
            LOGGER.error("Can't get order status for order with id: " + orderId);
            throw new RuntimeException("Can't get order status");
        } else {
            LOGGER.info("Order with id " + orderId + " is closed");
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteOrderById(int id) {

        if (ordersStatus.get(id)) {
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM ord WHERE ID = ?")) {
                statement.setInt(1, id);
                statement.execute();
            } catch (SQLException e) {
                LOGGER.error("Exception occurred while connecting to DB ", e);
                throw new RuntimeException("Cannot find order with id: " + id);
            }

        } else if (ordersStatus.get(id) == null) {
            LOGGER.error("Can't get order status for order with id: " + id);
            throw new RuntimeException("Can't get order status");
        } else {
            LOGGER.info("Order with id " + id + " is closed");
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findAllOpenOrders() {
        List<Order> allOrders = findAll();
        List<Order> result = new ArrayList<>();

        for (Order order: allOrders) {
            if (ordersStatus.get(order.getId())) {
                result.add(order);
            }
        }

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findAllClosedOrders() {
        List<Order> allOrders = findAll();
        List<Order> result = new ArrayList<>();

        for (Order order: allOrders) {
            if (!ordersStatus.get(order.getId())) {
                result.add(order);
            }
        }

        return result;
    }

    @Override
    public void closeOrder(int id) {
        ordersStatus.put(id, false);
    }

    private List<Order> findAll() {
        List<Order> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ord");

            while (resultSet.next()) {
                Order order = createOrder(resultSet);
                result.add(order);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }

        return result;
    }

    private Order createOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("ID"));
        order.setTableNumber(resultSet.getInt("table_number"));
        order.setDate(resultSet.getDate("date").toLocalDate());
        order.setEmployee(employeeDao.getById(resultSet.getInt("employee_id")));
        order.setDish(dishDao.getById(resultSet.getInt("dish_id")));
        return order;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
