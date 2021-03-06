package goit.hw7.controllers;

import goit.hw7.model.DaoInterfaces.StoreDao;
import goit.hw7.model.Store;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StoreController {

    private StoreDao storeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Store store) {
        storeDao.save(store);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Store store) {
        storeDao.remove(store);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeQuantityOfIngredients(String ingredientName, int quantity) {
        storeDao.changeQuantityOfIngredients(ingredientName, quantity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Store findByIngredientsName(String name) {
        return storeDao.findByIngredientsName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Store> findAll() {
        return storeDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Store> findEndsIngredients(){
        return storeDao.findEndsIngredients();
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }
}
