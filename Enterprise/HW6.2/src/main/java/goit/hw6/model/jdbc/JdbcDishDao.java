package goit.hw6.model.jdbc;

import goit.hw6.model.DaoInterfaces.DishDao;
import goit.hw6.model.DaoInterfaces.EmployeeDao;
import goit.hw6.model.Dish;
import goit.hw6.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDishDao implements DishDao{

    private DataSource dataSource;
    private JdbcIngredientDao ingredientDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
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
            throw new RuntimeException("Cannot find Dish with name: " + name);
        }

        return result;
    }

    private Dish createDish(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();

        dish.setId(resultSet.getInt("ID"));
        dish.setName(resultSet.getString("NAME"));
        dish.setCategory(resultSet.getString("CATEGORY"));
        dish.setIngredient(getIngredientsList(dish.getId()));
        dish.setPrice(resultSet.getDouble("PRICE"));
        dish.setWeight(resultSet.getDouble("WEIGHT"));

        return dish;

    }

    private List<Ingredient> getIngredientsList(int dishId) {
        List<Ingredient> ingredients = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT ingredient_name FROM ingredients_for_dish WHERE dish_id = ?")) {
            statement.setInt(1, dishId);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Ingredient ingredient = ingredientDao.createIngredient(resultSet);
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB", e);
            throw new RuntimeException("Cannot find Ingredients for dish id: " + dishId);
        }

        return ingredients;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setIngredientDao(JdbcIngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
