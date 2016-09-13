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

    @RequestMapping(value = "/store/delete", method = RequestMethod.POST)
    public void store(@RequestBody Store store){
        storeService.delete(store);
    }

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }
}
