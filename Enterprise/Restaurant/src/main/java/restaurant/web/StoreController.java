package restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.model.Store;
import restaurant.service.IngredientService;
import restaurant.service.StoreService;

import java.util.List;

@RestController
public class StoreController {

    private StoreService storeService;
    private IngredientService ingredientService;

    @RequestMapping(value = "/admin/getAllStore", method = RequestMethod.GET)
    public List<Store> store(){
        return storeService.findAll();
    }

    @RequestMapping(value = "/admin/store/id={id}", method = RequestMethod.GET)
    public Store getById(@PathVariable int id) {
        return storeService.getById(id);
    }

    @RequestMapping(value = "/admin/store/delete", method = RequestMethod.POST)
    public void store(@RequestBody Store store){
        storeService.delete(store);
    }

    @RequestMapping(value = "/admin/store/update", method = RequestMethod.POST)
    public void update(@RequestBody Store store) {
        System.out.println(store);
        storeService.createOrUpdate(store);
    }

    @RequestMapping(value = "/admin/store/create", method = RequestMethod.POST)
    public void create(@RequestBody Store store) {
        ingredientService.createOrUpdate(store.getIngredient());
        storeService.createOrUpdate(store);
    }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }
}
