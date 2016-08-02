package goit.hw6;

import goit.hw6.controllers.DishController;
import goit.hw6.controllers.EmployeeController;
import goit.hw6.controllers.MenuController;
import goit.hw6.controllers.OrderController;
import goit.hw6.model.DaoInterfaces.IngredientDao;
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
    private IngredientDao ingredientDao;
    private OrderController orderController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        //employeeController.getAllEmployees().forEach(System.out::println);



    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
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
