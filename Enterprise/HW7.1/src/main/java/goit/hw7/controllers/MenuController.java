package goit.hw7.controllers;

import goit.hw7.model.DaoInterfaces.MenuDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Menu;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class MenuController {

    private MenuDao menuDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDish(Dish dish, Menu targetMenu) {
        menuDao.deleteDish(dish, targetMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Menu getByName(String name) {
        return menuDao.getByName(name);
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
