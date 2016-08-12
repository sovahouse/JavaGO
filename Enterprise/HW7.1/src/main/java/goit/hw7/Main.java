package goit.hw7;

import goit.hw7.controllers.*;
import goit.hw7.model.Dish;
import goit.hw7.model.Employee;
import goit.hw7.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;
    private MenuController menuController;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        /*Dish salad = dishController.getById(1);
        dishController.deleteDish(salad);
        System.out.println("After delete"); dishController.getAllDishes().forEach(System.out::println);
        dishController.createDish(salad);
        System.out.println("After add"); dishController.getAllDishes().forEach(System.out::println);
        List <Dish> dishes = dishController.getDishByName("Feta Pizza");
        dishes.forEach(System.out::println);*/

        Dish salad = dishController.getById(1);
        Menu menu = menuController.getByName("Salad");
        menuController.deleteDish(salad, menu);
        menuController.addDish(salad, menu);

    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
