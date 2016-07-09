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

    //TODO: testing all methods below
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Dish> getAll() {
        return dishDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDish(Dish dish) {
        dishDao.addDish(dish);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDish(int id) {
        dishDao.deleteDishById(id);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
