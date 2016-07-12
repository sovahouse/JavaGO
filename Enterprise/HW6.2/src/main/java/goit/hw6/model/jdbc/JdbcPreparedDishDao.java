package goit.hw6.model.jdbc;

import goit.hw6.model.DaoInterfaces.PreparedDishDao;
import goit.hw6.model.PreparedDish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JdbcPreparedDishDao implements PreparedDishDao { //TODO: testing

    private DataSource dataSource;
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

    private PreparedDish createPreparedDish(ResultSet resultSet) throws SQLException {
        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setId(resultSet.getInt("ID"));
        preparedDish.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
        preparedDish.setDishId(resultSet.getInt("DISH_ID"));
        preparedDish.setOrderId(resultSet.getInt("ORDER_ID"));
        preparedDish.setDishesNumber(resultSet.getInt("DISHES_NUMBER"));
        preparedDish.setDate(resultSet.getDate("DATE").toLocalDate());
        return preparedDish;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
