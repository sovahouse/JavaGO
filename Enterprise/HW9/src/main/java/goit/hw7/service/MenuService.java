package goit.hw7.service;

import goit.hw7.model.DaoInterfaces.MenuDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Menu;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuService {

    private MenuDao menuDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void createMenu(Menu menu) {
        menuDao.add(menu);
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
    public Menu getByName(String name) {
        return menuDao.getByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
