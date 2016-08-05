package goit.hw6;

import goit.hw6.controllers.*;
import goit.hw6.model.*;
import goit.hw6.model.DaoInterfaces.IngredientDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;
    private MenuController menuController;
    private IngredientDao ingredientDao;
    private OrderController orderController;
    private KitchenHistoryController kitchenHistoryController;
    private StoreController storeController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        //employeeController.getAllEmployees().forEach(System.out::println);

        /*PreparedDish preparedDish = new PreparedDish();
        LocalDate localDate = LocalDate.now();

        Order order = new Order();
        order.setId(1);
        order.setEmployee(employeeController.getById(1));
        order.setDish(dishController.getById(1));
        order.setDate(localDate);
        order.setTableNumber(1);

        orderController.createOrder(order);
        preparedDish.setId(1);
        preparedDish.setDate(localDate);
        preparedDish.setDish(dishController.getById(1));
        preparedDish.setDishNumber(123);
        preparedDish.setEmployee(employeeController.getById(1));
        preparedDish.setOrder(order);

        kitchenHistoryController.addPreparedDishes(preparedDish);
        kitchenHistoryController.findAll().forEach(System.out::println);*/

        //storeController.addIngredient(ingredientDao.getByName("Bacon"), 100);
        storeController.addIngredient(ingredientDao.getByName("Tomato"), 7);
        //storeController.addIngredient(ingredientDao.getByName("Dough"), 9);
        //storeController.deleteIngredient("Tomato");
        storeController.findAll().forEach(System.out::println);

        /*System.out.println("All:");
        storeController.findAll().forEach(System.out::println);
        System.out.println("Ends:");
        storeController.findEndsIngredients().forEach(System.out::println);

        storeController.changeQuantityOfIngredients("Bacon", 5);
        System.out.println(storeController.findIngredientByName("Bacon"));*/

    }

    public void setStoreController(StoreController storeController) {
        this.storeController = storeController;
    }

    public void setKitchenHistoryController(KitchenHistoryController kitchenHistoryController) {
        this.kitchenHistoryController = kitchenHistoryController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
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
