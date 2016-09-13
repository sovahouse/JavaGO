package restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import restaurant.model.Employee;
import restaurant.model.Order;
import restaurant.service.*;

import java.time.LocalDate;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeService employeeService;
    private DishService dishService;
    private MenuService menuService;
    private StoreService storeService;
    private OrderService orderService;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/application-context.xml", "src/main/webapp/WEB-INF/hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        /*Dish salad = dishService.getById(1);
        dishService.deleteDish(salad);
        System.out.println("After delete"); dishService.getAllDishes().forEach(System.out::println);
        dishService.createDish(salad);
        System.out.println("After saveOrUpdate"); dishService.getAllDishes().forEach(System.out::println);
        List <Dish> dishes = dishService.getDishByName("Feta Pizza");
        dishes.forEach(System.out::println);*/

       /* Dish salad = dishService.getById(1);
        Menu menu = menuService.getByName("Salad");
        menuService.deleteDish(salad, menu);
        menuService.addDish(salad, menu);*/

        Order order = new Order();
        Employee waiter = employeeService.getById(1);
        order.setDate(LocalDate.now());
        order.setTableNumber(1);
        order.setWaiter(waiter);

        orderService.create(order);
        orderService.addDish(dishService.getDishByName("Classic Chicken Salad"), order);
        orderService.addDish(dishService.getDishByName("Feta Pizza"), order);

        orderService.closeOrder(order);
        employeeService.getAllEmployees().forEach(System.out::println);


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
}
