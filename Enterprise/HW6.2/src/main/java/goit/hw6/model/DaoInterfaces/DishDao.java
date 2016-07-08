package goit.hw6.model.DaoInterfaces;


import goit.hw6.model.Dish;

import java.util.List;

public interface DishDao {

    public List<Dish> findByName(String name);

}
