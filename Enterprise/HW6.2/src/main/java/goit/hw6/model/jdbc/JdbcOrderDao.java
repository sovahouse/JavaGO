package goit.hw6.model.jdbc;

import goit.hw6.model.DaoInterfaces.DishDao;
import goit.hw6.model.DaoInterfaces.EmployeeDao;
import goit.hw6.model.DaoInterfaces.OrderDao;
import goit.hw6.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;

public class JdbcOrderDao implements OrderDao {

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDao.class);
    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private Map ordersStatus;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addOrder(Order order) { //TODO: testing
        String query = "INSERT INTO ord (ID, table_number, data, employee_id, dish_id)" +
                "VALUES (?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getId());
            statement.setInt(2, order.getTableNumber());
            statement.setDate(3, Date.valueOf(order.getDate()));
            statement.setInt(4, order.getEmployee().getId());
            statement.setInt(5, order.getDish().getId());

            statement.execute();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot add new prepared dish" + order.toString());
        }
    }

    @Override
    public Order getById(int id) { //TODO: testing
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

    private Order createOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("ID"));
        order.setTableNumber(resultSet.getInt("table_number"));
        order.setDate(resultSet.getDate("data").toLocalDate());
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
