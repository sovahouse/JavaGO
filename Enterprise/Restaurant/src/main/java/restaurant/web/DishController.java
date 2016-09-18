package restaurant.web;

import restaurant.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.service.DishService;
import restaurant.service.MenuService;

import java.util.List;

@RestController
public class DishController {

    private DishService dishService;
    private MenuService menuService;

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

    @RequestMapping(value = "/admin/dishes/delete", method = RequestMethod.POST)
    public void delete(@RequestBody  Dish dish) {
        menuService.deleteDishFromAllMenus(dish);
        dishService.deleteDish(dish);
    }
    @RequestMapping(value = "/admin/dishes/createOrUpdate", method = RequestMethod.POST)
    public void createOrUpdate(@RequestBody Dish dish) {
        dishService.createOrUpdateDish(dish);
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
