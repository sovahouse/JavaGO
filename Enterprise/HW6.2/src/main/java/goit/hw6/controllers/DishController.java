package goit.hw6.controllers;

import goit.hw6.model.DaoInterfaces.DishDao;
import goit.hw6.model.Dish;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishController {

    private DishDao dishDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Dish> getDishByName(String name) {
        return dishDao.findByName(name);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
