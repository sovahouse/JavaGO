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

    @RequestMapping(value = "/dishes/name={dishName}", method = RequestMethod.GET)
    public Dish getDishByName(@PathVariable("dishName") String dishName) {
        return dishService.getDishByName(dishName);
    }

    @RequestMapping(value = "/dishes/id={id}", method = RequestMethod.GET)
    public Dish getDishById(@PathVariable("id") int id) {
        return dishService.getById(id);
    }
    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
