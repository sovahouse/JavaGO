package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Ingredient;
import goit.hw7.model.Store;

import java.util.List;

public interface StoreDao {

    void addIngredient(Ingredient ingredient, int quantity);
    void deleteIngredientByName(String name);
    void changeQuantityOfIngredients(String ingredientName, int quantity);
    Store findIngredientByName(String name);
    List<Store> findAll();
    List<Store> findEndsIngredients();

}
