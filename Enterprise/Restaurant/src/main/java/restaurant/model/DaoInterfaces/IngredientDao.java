package restaurant.model.DaoInterfaces;

import restaurant.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    List<Ingredient> findAll();

    void createOrUpdate(Ingredient ingredient);
}

