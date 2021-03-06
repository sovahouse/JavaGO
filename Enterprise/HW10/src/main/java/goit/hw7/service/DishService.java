package goit.hw7.service;

import goit.hw7.model.DaoInterfaces.DishDao;
import goit.hw7.model.Dish;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class DishService {

    private DishDao dishDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Dish getById(int id) {
        return dishDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createDish(Dish dish) {
        dishDao.save(dish);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDish(Dish dish) {
        dishDao.remove(dish);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
