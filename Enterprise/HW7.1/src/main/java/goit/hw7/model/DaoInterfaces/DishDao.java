package goit.hw7.model.DaoInterfaces;


import goit.hw7.model.Dish;

import java.util.List;

public interface DishDao {

    List<Dish> findAll();

    List<Dish> findByName(String name);

    void deleteDishById(int id);

    void addDish(Dish dish);

    Dish getById(int id);

}
