package restaurant.web;

import restaurant.model.Dish;
import restaurant.model.Employee;
import restaurant.model.Order;
import restaurant.service.DishService;
import restaurant.service.EmployeeService;
import restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class BootController {

    private EmployeeService employeeService;
    private OrderService orderService;
    private DishService dishService;

    @RequestMapping(value = "/boot", method = RequestMethod.GET)
    public void boot() {
        Order order1 = new Order();
        Employee waiter = employeeService.getById(1);
        order1.setDate(LocalDate.now());
        order1.setTableNumber(1);
        order1.setWaiter(waiter);

        orderService.create(order1);

        orderService.addDish(dishService.getById(1), order1);
        orderService.addDish(dishService.getById(2), order1);
        orderService.closeOrder(order1);

        Order order2 = new Order();
        Employee waiter2 = employeeService.getById(2);
        order2.setDate(LocalDate.now());
        order2.setTableNumber(5);
        order2.setWaiter(waiter2);

        orderService.create(order2);

        orderService.addDish(dishService.getById(1), order2);
        orderService.addDish(dishService.getById(2), order2);
        orderService.closeOrder(order2);

    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
