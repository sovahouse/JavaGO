package restaurant.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import restaurant.model.DaoInterfaces.IngredientDao;
import restaurant.model.Ingredient;

import java.util.List;

public class IngredientService {

    private IngredientDao ingredientDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Ingredient> fingAll() {
        return ingredientDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrUpdate(Ingredient ingredient) {
        ingredientDao.createOrUpdate(ingredient);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Ingredient ingredient) {
        ingredientDao.remove(ingredient);
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
