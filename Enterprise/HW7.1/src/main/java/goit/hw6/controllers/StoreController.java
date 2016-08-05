package goit.hw6.controllers;

import goit.hw6.model.DaoInterfaces.StoreDao;
import goit.hw6.model.Ingredient;
import goit.hw6.model.Store;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StoreController {

    private StoreDao storeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addIngredient(Ingredient ingredient, int quantity) {
        storeDao.addIngredient(ingredient, quantity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteIngredient(String name) {
        storeDao.deleteIngredientByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeQuantityOfIngredients(String ingredientName, int quantity) {
        storeDao.changeQuantityOfIngredients(ingredientName, quantity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Store findIngredientByName(String name) {
        return storeDao.findIngredientByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Store> findAll() {
        return storeDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Store> findEndsIngredients() {
        return storeDao.findEndsIngredients();
    }
    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }
}
