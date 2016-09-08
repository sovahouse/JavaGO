package restaurant.web;

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
        Order order = new Order();
        Employee waiter = employeeService.getById(1);
        order.setDate(LocalDate.now());
        order.setTableNumber(1);
        order.setWaiter(waiter);

        orderService.create(order);
        orderService.addDish(dishService.getDishByName("Classic Chicken Salad"), order);
        orderService.addDish(dishService.getDishByName("Feta Pizza"), order);

        //orderService.closeOrder(order);
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
