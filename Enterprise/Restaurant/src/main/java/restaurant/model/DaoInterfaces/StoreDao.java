package restaurant.model.DaoInterfaces;

import restaurant.model.Store;

import java.util.List;

public interface StoreDao {

    void createOrUpdate(Store store);
    void remove(Store store);
    void changeQuantityOfIngredients(int ingredientId, int quantity);
    Store findByIngredientsName(String name);
    List<Store> findAll();
    List<Store> findEndsIngredients();
    Store getById(int id);
}
