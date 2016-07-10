package goit.hw6;

import goit.hw6.controllers.DishController;
import goit.hw6.controllers.EmployeeController;
import goit.hw6.controllers.MenuController;
import goit.hw6.model.Dish;
import goit.hw6.model.Employee;
import goit.hw6.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;
    private MenuController menuController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        //employeeController.getAllEmployees().forEach(System.out::println);
        //employeeController.getEmployeeByName("Robert").forEach(System.out::println);
        //Employee employee = employeeController.getById(1);
        //employeeController.deleteEmployee(1);
        //employeeController.addEmployee(employee);


        //dishController.getDishByName("Fried eggs").forEach(System.out::println);
        //Dish dish = dishController.getById(1);   System.out.println(dish);
        //dish.setId(2);
        //dishController.getAll().forEach(System.out::println);
        //dishController.addDish(dish);
        //dishController.deleteDish(1);

        menuController.findAll().forEach(System.out::println);
//        Menu menu = new Menu();
//        List<Dish> dish = new ArrayList<>();
//        dish.add(dishController.getById(2));
//        menu.setName("Salats");
//        menu.setDishes(dish);
//        menuController.addMenu(menu);

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
