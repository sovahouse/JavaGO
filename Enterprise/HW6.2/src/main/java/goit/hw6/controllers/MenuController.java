package goit.hw6.controllers;

import goit.hw6.model.DaoInterfaces.MenuDao;
import goit.hw6.model.Menu;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuController {

    private MenuDao menuDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
