package restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.model.Store;
import restaurant.service.StoreService;

import java.util.List;

@RestController
public class StoreController {

    private StoreService storeService;

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public List<Store> store(){
        return storeService.findAll();
    }

    @RequestMapping(value = "/store/id={id}", method = RequestMethod.GET)
    public Store getById(@PathVariable int id) {
        return storeService.getById(id);
    }

    @RequestMapping(value = "/store/delete", method = RequestMethod.POST)
    public void store(@RequestBody Store store){
        storeService.delete(store);
    }

    @RequestMapping(value = "/store/createOrUpdate", method = RequestMethod.POST)
    public void createOrUpdate(@RequestBody Store store) {
        System.out.println(store);
        storeService.createOrUpdate(store);
    }

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }
}
