package goit.hw7.web;

import goit.hw7.model.Employee;
import goit.hw7.model.Order;
import goit.hw7.service.DishService;
import goit.hw7.service.EmployeeService;
import goit.hw7.service.OrderService;
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
