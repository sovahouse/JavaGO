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
        /*Ingredient bacon = new Ingredient();
        bacon.setName("Bacon");
        Ingredient tomato = new Ingredient();
        tomato.setName("Tomato");

        Store store = new Store();
        store.setIngredient(bacon);
        store.setQuantity(20);

        Store store1 = new Store();
        store1.setIngredient(tomato);
        store1.setQuantity(5);

        storeController.create(store);
        storeController.create(store1);
        System.out.println("All:"); storeController.findAll().forEach(System.out::println);

        Store store = storeController.findByName("Tomato");
        storeController.delete(store);
        System.out.println("after delete:"); storeController.findAll().forEach(System.out::println);
        storeController.create(store);
        System.out.println("ending:"); storeController.findEndsIngredients().forEach(System.out::println);
        storeController.changeQuantityOfIngredients("Tomato", 100);*/

        Order first = new Order();
        Employee employee = employeeController.getById(1);
        first.setDishes(dishController.getDishByName("Feta Pizza"));
        first.setDate(LocalDate.now());
        first.setTableNumber(1);
        first.setEmployee(employee);

        orderController.create(first);
        orderController.addDish(dishController.getDishByName("Classic Chicken Salad").get(0), first);
        orderController.deleteDish(dishController.getDishByName("Feta Pizza").get(0), first);
        Order getOrder = orderController.getById(1);
        orderController.closeOrder(getOrder);
        orderController.addDish(dishController.getDishByName("Classic Chicken Salad").get(0), getOrder);
        orderController.deleteDish(dishController.getDishByName("Feta Pizza").get(0), getOrder);
        orderController.delete(getOrder);

        orderController.create(first);
        orderController.findAllClosedOrders().forEach(System.out::println);
        orderController.findAllOpenedOrders().forEach(System.out::println);



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
}
