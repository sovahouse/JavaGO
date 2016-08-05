package goit.hw7.model.jdbc;

import goit.hw7.model.DaoInterfaces.IngredientDao;
import goit.hw7.model.DaoInterfaces.StoreDao;
import goit.hw7.model.Ingredient;
import goit.hw7.model.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoreDao implements StoreDao {

    private DataSource dataSource;
    private IngredientDao ingredientDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addIngredient(Ingredient ingredient, int quantity) {

        String query = "INSERT INTO STORE (QUANTITY, ingredient_name) VALUES (?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, quantity);
            statement.setString(2, ingredient.getName());

            statement.execute();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot add new ingredient" + ingredient.toString());
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteIngredientByName(String name) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM store WHERE Ingredient_NAME = ?")) {
            statement.setString(1, name);
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Ingredient with name: " + name);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void changeQuantityOfIngredients(String ingredientName, int quantity) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE store SET quantity = ? WHERE ingredient_name = ?")){
            statement.setInt(1, quantity);
            statement.setString(2, ingredientName);
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot update quantity of ingredient: " + ingredientName);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Store findIngredientByName(String name) {

        Store store = new Store();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM store WHERE ingredient_name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                store = createStore(resultSet);
            }

            return store;

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Ingredient with name: " + name);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Store> findAll() {
        List<Store> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Store");

            while (resultSet.next()) {
                Store store = createStore(resultSet);
                result.add(store);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Store> findEndsIngredients() {

        List<Store> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM store WHERE quantity < 10");

            while (resultSet.next()) {
                Store store = createStore(resultSet);
                result.add(store);
            }

            return result;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }
    }

    private Store createStore(ResultSet resultSet) throws SQLException {

        Store store = new Store();

        store.setIngredient(ingredientDao.getByName(resultSet.getString("ingredient_name")));
        store.setQuantity(resultSet.getInt("quantity"));

        return store;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
