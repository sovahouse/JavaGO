package goit.hw6.model.jdbc;

import goit.hw6.model.Ingredient;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcIngredientDao {

    private DataSource dataSource;

    public Ingredient createIngredient(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();

        ingredient.setName(resultSet.getString("NAME"));

        return ingredient;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
