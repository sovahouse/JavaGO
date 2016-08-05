package goit.hw7.controllers;

import goit.hw7.model.DaoInterfaces.DishDao;
import goit.hw7.model.Dish;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishController {

    private DishDao dishDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Dish> getDishByName(String name) {
        return dishDao.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Dish getById(int id) {
       return dishDao.getById(id);
    }

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
