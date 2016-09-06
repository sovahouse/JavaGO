package goit.hw7.web;

import goit.hw7.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DishController {

    private DishService dishService;

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public String getAllDishes(Map<String, Object> model) {
        model.put("dishes", dishService.getAllDishes());
        return "dishes";
    }

    @RequestMapping(value = "/dish", method = RequestMethod.POST)
    public ModelAndView findDish(@RequestParam("search") String name) {
        return getDish(name);
    }

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView getDish(@RequestParam("dishName") String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishByName(dishName));
        modelAndView.setViewName("dish");
        return modelAndView;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
