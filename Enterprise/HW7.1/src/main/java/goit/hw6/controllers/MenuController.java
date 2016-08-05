package goit.hw6.controllers;

import goit.hw6.model.DaoInterfaces.MenuDao;
import goit.hw6.model.Menu;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuController {

    private MenuDao menuDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDishes(int id, Menu targetMenu) {
        menuDao.deleteDishesById(id, targetMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDishes(int id, Menu targetMenu) {
        menuDao.addDishesById(id, targetMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMenu(String name) {
        menuDao.deleteMenuByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addMenu(Menu menu) {
        menuDao.addMenu(menu);
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
