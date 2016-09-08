package restaurant.web;

import restaurant.model.Dish;
import restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    private DishService dishService;

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @RequestMapping(value = "/dishes", params = "dishName", method = RequestMethod.POST)
    public Dish findDish(@RequestParam String dishName) {
        return dishService.getDishByName(dishName);
    }

    @RequestMapping(value = "/dishes/{dishName}", method = RequestMethod.GET)
    public Dish getDish(@PathVariable("dishName") String dishName) {
        return dishService.getDishByName(dishName);
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
