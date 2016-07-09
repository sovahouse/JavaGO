package goit.hw6.model.jdbc;

import goit.hw6.model.DaoInterfaces.IngredientDao;
import goit.hw6.model.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcIngredientDao implements IngredientDao{

    @Override
    public Ingredient createIngredientFrom(ResultSet resultSet, String table) throws SQLException {
        Ingredient ingredient = new Ingredient();

        ingredient.setName(resultSet.getString(table));

        return ingredient;
    }

}
