package restaurant.model.DaoInterfaces;


import restaurant.model.Dish;
import restaurant.model.Ingredient;

import java.util.List;

public interface DishDao {

    List<Dish> findAll();

    Dish findByName(String name);

    void remove(Dish dish);

    void createOrUpdate(Dish dish);

    Dish getById(int id);

    void deleteIngredientFromAllDishes(Ingredient ingredient);
}
