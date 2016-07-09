package goit.hw6.model.DaoInterfaces;


import goit.hw6.model.Dish;

import java.sql.ResultSet;
import java.util.List;

public interface DishDao {

    List<Dish> findAll();

    List<Dish> findByName(String name);

    void deleteDishById(int id);

    void addDish(Dish dish);

    Dish getById(int id);

}
