package goit.hw6.model.DaoInterfaces;

import goit.hw6.model.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IngredientDao {

    public Ingredient createIngredientFrom(ResultSet resultSet, String query) throws SQLException;
}
