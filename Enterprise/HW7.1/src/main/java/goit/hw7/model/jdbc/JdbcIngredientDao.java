package goit.hw7.model.jdbc;

import goit.hw7.model.DaoInterfaces.IngredientDao;
import goit.hw7.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcIngredientDao implements IngredientDao{

    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientDao.class);

    @Override
    public Ingredient createIngredientFrom(ResultSet resultSet, String table) throws SQLException {
        Ingredient ingredient = new Ingredient();

        ingredient.setName(resultSet.getString(table));

        return ingredient;
    }

    @Override
    public Ingredient getByName(String name) {

        Ingredient ingredient = new Ingredient();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM INGREDIENT WHERE NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredient = createIngredientFrom(resultSet, "name");
            }
            return ingredient;

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Ingredient with name: " + name);
        }

    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
