package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Dish;
import goit.hw7.model.Menu;

import java.util.List;


public interface MenuDao {

    void add(Menu menu);
    void remove(Menu menu);
    void deleteDish(Dish dish, Menu targetMenu/*TODO:List<Dish>*/);
    void addDish(Dish dish, Menu targetMenu/*List<Dish>*/);
    Menu getByName(String name);
    Menu getById(int id);
    List<Menu> findAll();

}
