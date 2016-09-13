package restaurant.web;

import restaurant.model.Order;
import restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @RequestMapping(value = "/order/opened", method = RequestMethod.GET)
    public List<Order> getAllOpenedOrders() {
        return orderService.findAllOpenedOrders();
    }

    @RequestMapping(value = "/order/closed", method = RequestMethod.GET)
    public List<Order> getAllClosedOrders() {
        return orderService.findAllClosedOrders();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
