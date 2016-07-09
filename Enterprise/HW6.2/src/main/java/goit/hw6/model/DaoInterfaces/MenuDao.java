package goit.hw6.model.DaoInterfaces;

import goit.hw6.model.Dish;
import goit.hw6.model.Menu;

import java.util.List;


public interface MenuDao {

    void addMenu(Menu menu);
    void deleteMenuById(int id);
    void deleteDishesById(/*List<Dish>*/);
    void addDishesById(/*List<Dish>*/);
    List<Menu> findAll();

}
