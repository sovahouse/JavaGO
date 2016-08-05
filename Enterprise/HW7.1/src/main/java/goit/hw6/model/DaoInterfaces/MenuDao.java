package goit.hw6.model.DaoInterfaces;

import goit.hw6.model.Dish;
import goit.hw6.model.Menu;

import java.util.List;


public interface MenuDao {

    void addMenu(Menu menu);
    void deleteMenuByName(String name);
    void deleteDishesById(int id, Menu targetMenu/*List<Dish>*/);
    void addDishesById(int id, Menu targetMenu/*List<Dish>*/);
    List<Menu> findAll();

}
