package goit.hw7;

import goit.hw7.service.*;
import goit.hw7.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeService employeeService;
    private DishService dishService;
    private MenuService menuService;
    private StoreService storeService;
    private OrderService orderService;
    private CookService cookController;
    private WaiterService waiterController;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/application-context.xml", "WEB-INF/hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        /*Dish salad = dishService.getById(1);
        dishService.deleteDish(salad);
        System.out.println("After delete"); dishService.getAllDishes().forEach(System.out::println);
        dishService.createDish(salad);
        System.out.println("After save"); dishService.getAllDishes().forEach(System.out::println);
        List <Dish> dishes = dishService.getDishByName("Feta Pizza");
        dishes.forEach(System.out::println);*/

       /* Dish salad = dishService.getById(1);
        Menu menu = menuService.getByName("Salad");
        menuService.deleteDish(salad, menu);
        menuService.addDish(salad, menu);*/

        /*Order order = new Order();
        Waiter waiter = waiterController.getById(1);
        order.setDishes(dishService.getDishByName("Feta Pizza"));
        order.setDate(LocalDate.now());
        order.setTableNumber(1);
        order.setCook(cookController.getById(3));
        order.setWaiter(waiter);

        orderService.create(order);
        orderService.addDish(dishService.getDishByName("Classic Chicken Salad").get(0), order);
        orderService.deleteDish(dishService.getDishByName("Classic Chicken Salad").get(0), order);

        orderService.prepareDish(dishService.getDishByName("Feta Pizza").get(0), order);
        orderService.closeOrder(order);
        System.out.println();

        cookController.getById(3).getPreparedDishes().forEach(System.out::println);
        System.out.println();*/

        employeeService.getAllEmployees().forEach(System.out::println);


    }

    public void setWaiterController(WaiterService waiterController) {
        this.waiterController = waiterController;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    public void setCookController(CookService cookController) {
        this.cookController = cookController;
    }
}
