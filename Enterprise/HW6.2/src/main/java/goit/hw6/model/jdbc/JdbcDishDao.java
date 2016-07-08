package goit.hw6.model.jdbc;

import goit.hw6.model.DaoInterfaces.DishDao;
import goit.hw6.model.DaoInterfaces.EmployeeDao;
import goit.hw6.model.Dish;
import goit.hw6.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDishDao implements DishDao{

    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    public List<Dish> findByName(String name) {
        List<Dish> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM DISH WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Dish dish = createDish(resultSet);
                result.add(dish);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Employee with name: " + name);
        }

        return result;
    }

    private Dish createDish(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();

        dish.setId(resultSet.getInt("ID"));
        dish.setName(resultSet.getString("NAME"));
        dish.setCategory(resultSet.getString("CATEGORY"));
        dish.setIngredient(resultSet.getObject("INGREDIENT"));
        dish.setPrice(resultSet.getDouble("PRICE"));
        dish.setWeight(resultSet.getDouble("WEIGHT"));

        return dish;
    }

    private List<Ingredient> getIngredientsList() {

    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
