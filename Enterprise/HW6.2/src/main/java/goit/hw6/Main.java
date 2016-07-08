package goit.hw6;

import goit.hw6.controllers.DishController;
import goit.hw6.controllers.EmployeeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        //employeeController.getAllEmployees().forEach(System.out::println);
        //employeeController.getEmployeeByName("Robert").forEach(System.out::println);
        //employeeController.deleteEmployee(1);
        dishController.getDishByName("Fried eggs").forEach(System.out::println);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

}
