package restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import restaurant.model.Ingredient;
import restaurant.service.IngredientService;

import java.util.List;

@RestController
public class IngredientController {

    private IngredientService ingredientService;

    @RequestMapping(value = "/admin/ingredients", method = RequestMethod.GET)
    public List<Ingredient> employees() {
        return ingredientService.fingAll();
    }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
}
