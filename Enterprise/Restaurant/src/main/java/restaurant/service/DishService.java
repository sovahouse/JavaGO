package restaurant.service;

import restaurant.model.DaoInterfaces.DishDao;
import restaurant.model.Dish;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import restaurant.model.Ingredient;

import java.util.List;


public class DishService {

    private DishDao dishDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Dish getById(int id) {
        return dishDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrUpdateDish(Dish dish) {
        dishDao.createOrUpdate(dish);
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

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteIngredientFromAllDishes(Ingredient ingredient) {
        dishDao.deleteIngredientFromAllDishes(ingredient);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
