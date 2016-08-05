package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IngredientDao {

    Ingredient createIngredientFrom(ResultSet resultSet, String query) throws SQLException;
    Ingredient getByName(String name);
}
