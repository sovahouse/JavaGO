package restaurant.service;

import restaurant.model.DaoInterfaces.MenuDao;
import restaurant.model.Dish;
import restaurant.model.Menu;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuService {

    private MenuDao menuDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrUpdate(Menu menu) {
        menuDao.createOrUpdate(menu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMenu(Menu menu) {
        menuDao.remove(menu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDish(Dish dish, Menu targetMenu) {
        menuDao.deleteDish(dish, targetMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDish(Dish dish, Menu targetMenu) {
        menuDao.addDish(dish, targetMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDishFromAllMenus(Dish dish) {
        menuDao.deleteDishFromAllMenus(dish);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Menu getByName(String name) {
        return menuDao.getByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Menu getById(int id) {
        return menuDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
