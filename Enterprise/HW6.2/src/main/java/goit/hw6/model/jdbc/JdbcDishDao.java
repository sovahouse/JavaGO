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

public class JdbcDishDao implements DishDao {

    private DataSource dataSource;
    private JdbcIngredientDao ingredientDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(DishDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> findAll() {
        List<Dish> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DISH");

            while (resultSet.next()) {
                Dish dish = createDish(resultSet);
                result.add(dish);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }

        return result;
    }

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

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish getById(int id) {

        Dish dish = new Dish();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM DISH WHERE ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dish = createDish(resultSet);
            }

            return dish;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Dish with id: " + id);
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDishById(int id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM DISH WHERE ID = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Dish with id: " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDish(Dish dish) {
        String mainInfoQuery = "INSERT INTO DISH (ID, NAME, CATEGORY, PRICE, WEIGHT) " +
                "VALUES (?, ?, ?, ?, ?)";
        String ingredientsListQuery = "INSERT INTO ingredients_for_dish (dish_id, ingredient_name)" +
                "VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement mainInfoStatement = connection.prepareStatement(mainInfoQuery);
             PreparedStatement ingredientsListStatement = connection.prepareStatement(ingredientsListQuery)) {

            mainInfoStatement.setInt(1, dish.getId());
            mainInfoStatement.setString(2, dish.getName());
            mainInfoStatement.setString(3, dish.getCategory());
            mainInfoStatement.setDouble(4, dish.getPrice());
            mainInfoStatement.setDouble(5, dish.getWeight());

            for (Ingredient ingredient : dish.getIngredients()) {
                ingredientsListStatement.setInt(1, dish.getId());
                ingredientsListStatement.setString(2, ingredient.getName());
                ingredientsListStatement.execute();
            }

            mainInfoStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot add new dish" + dish.toString());
        }
    }

    public Dish createDish(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();

        dish.setId(resultSet.getInt("ID"));
        dish.setName(resultSet.getString("NAME"));
        dish.setCategory(resultSet.getString("CATEGORY"));
        dish.setIngredients(getIngredientsList(dish.getId()));
        dish.setPrice(resultSet.getDouble("PRICE"));
        dish.setWeight(resultSet.getDouble("WEIGHT"));

        return dish;

    }

    private List<Ingredient> getIngredientsList(int dishId) {
        List<Ingredient> ingredients = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT ingredient_name FROM ingredients_for_dish WHERE dish_id = ?")) {
            statement.setInt(1, dishId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Ingredient ingredient = ingredientDao.createIngredientFrom(resultSet, "INGREDIENT_NAME");
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
