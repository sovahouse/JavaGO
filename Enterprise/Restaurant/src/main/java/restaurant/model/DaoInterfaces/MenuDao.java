package restaurant.model.DaoInterfaces;

import restaurant.model.Dish;
import restaurant.model.Menu;

import java.util.List;


public interface MenuDao {

    void createOrUpdate(Menu menu);
    void remove(Menu menu);
    void deleteDish(Dish dish, Menu targetMenu);
    void addDish(Dish dish, Menu targetMenu);
    void deleteDishFromAllMenus(Dish dish);
    Menu getByName(String name);
    Menu getById(int id);
    List<Menu> findAll();

}
