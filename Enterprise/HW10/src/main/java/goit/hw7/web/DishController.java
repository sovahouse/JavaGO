package goit.hw7.web;

import goit.hw7.model.Dish;
import goit.hw7.model.Employee;
import goit.hw7.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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
