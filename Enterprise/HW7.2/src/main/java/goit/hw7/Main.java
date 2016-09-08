package goit.hw7;

import goit.hw7.controllers.*;
import goit.hw7.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.List;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;
    private MenuController menuController;
    private StoreController storeController;
    private OrderController orderController;
    private CookController cookController;
    private WaiterController waiterController;


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
        System.out.println("After save"); dishController.getAllDishes().forEach(System.out::println);
        List <Dish> dishes = dishController.getDishByName("Feta Pizza");
        dishes.forEach(System.out::println);*/

       /* Dish salad = dishController.getById(1);
        Menu menu = menuController.getByName("Salad");
        menuController.deleteDish(salad, menu);
        menuController.addDish(salad, menu);*/

        /*Order order = new Order();
        Waiter waiter = waiterController.getById(1);
        order.setDishes(dishController.getDishByName("Feta Pizza"));
        order.setDate(LocalDate.now());
        order.setTableNumber(1);
        order.setCook(cookController.getById(3));
        order.setWaiter(waiter);

        orderController.create(order);
        orderController.addDish(dishController.getDishByName("Classic Chicken Salad").get(0), order);
        orderController.deleteDish(dishController.getDishByName("Classic Chicken Salad").get(0), order);

        orderController.prepareDish(dishController.getDishByName("Feta Pizza").get(0), order);
        orderController.closeOrder(order);
        System.out.println();

        cookController.getById(3).getPreparedDishes().forEach(System.out::println);
        System.out.println();*/

        orderController.findAllClosedOrders().forEach(System.out::println);


    }

    public void setWaiterController(WaiterController waiterController) {
        this.waiterController = waiterController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setStoreController(StoreController storeController) {
        this.storeController = storeController;
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

    public void setCookController(CookController cookController) {
        this.cookController = cookController;
    }
}
