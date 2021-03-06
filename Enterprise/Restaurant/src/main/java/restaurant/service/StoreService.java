package restaurant.service;

import restaurant.model.DaoInterfaces.StoreDao;
import restaurant.model.Store;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StoreService {

    private StoreDao storeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrUpdate(Store store) {
        storeDao.createOrUpdate(store);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Store store) {
        storeDao.remove(store);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeQuantityOfIngredients(int ingredientId, int quantity) {
        storeDao.changeQuantityOfIngredients(ingredientId, quantity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Store findByIngredientsName(String name) {
        return storeDao.findByIngredientsName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Store getById(int id) {
        return storeDao.getById(id);
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
