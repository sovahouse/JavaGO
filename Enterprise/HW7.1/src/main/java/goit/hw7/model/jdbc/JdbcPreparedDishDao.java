package goit.hw7.model.jdbc;

import goit.hw7.model.DaoInterfaces.DishDao;
import goit.hw7.model.DaoInterfaces.EmployeeDao;
import goit.hw7.model.DaoInterfaces.OrderDao;
import goit.hw7.model.DaoInterfaces.PreparedDishDao;
import goit.hw7.model.PreparedDish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcPreparedDishDao implements PreparedDishDao {

    private DataSource dataSource;
    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PreparedDishDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<PreparedDish> findAll() {
        List<PreparedDish> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM prepared_dishes");

            while (resultSet.next()) {
                PreparedDish preparedDish = createPreparedDish(resultSet);
                result.add(preparedDish);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addPreparedDish(PreparedDish preparedDish) {
        String query = "INSERT INTO Prepared_dishes (ID, dish_number, DATE, employee_id, dish_id, order_id)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, preparedDish.getId());
            statement.setInt(2, preparedDish.getDishNumber());
            statement.setDate(3, Date.valueOf(preparedDish.getDate()));
            statement.setInt(4, preparedDish.getEmployee().getId());
            statement.setInt(5, preparedDish.getDish().getId());
            statement.setInt(6, preparedDish.getOrder().getId());

            statement.execute();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot add new prepared dish" + preparedDish.toString());
        }
    }

    private PreparedDish createPreparedDish(ResultSet resultSet) throws SQLException {
        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setId(resultSet.getInt("ID"));
        preparedDish.setEmployee(employeeDao.getById(resultSet.getInt("EMPLOYEE_ID")));
        preparedDish.setDish(dishDao.getById(resultSet.getInt("DISH_ID")));
        preparedDish.setOrder(orderDao.getById(resultSet.getInt("ORDER_ID")));
        preparedDish.setDishNumber(resultSet.getInt("DISH_NUMBER"));
        preparedDish.setDate(resultSet.getDate("DATE").toLocalDate());
        return preparedDish;
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

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
