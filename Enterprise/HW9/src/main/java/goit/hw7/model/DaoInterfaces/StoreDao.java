package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Store;

import java.util.List;

public interface StoreDao {

    void save(Store store);
    void remove(Store store);
    void changeQuantityOfIngredients(String ingredientName, int quantity);
    Store findByIngredientsName(String name);
    List<Store> findAll();
    List<Store> findEndsIngredients();

}
