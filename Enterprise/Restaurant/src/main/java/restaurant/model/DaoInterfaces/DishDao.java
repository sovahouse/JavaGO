package restaurant.model.DaoInterfaces;


import restaurant.model.Dish;

import java.util.List;

public interface DishDao {

    List<Dish> findAll();

    Dish findByName(String name);

    void remove(Dish dish);

    void save(Dish dish);

    Dish getById(int id);

}