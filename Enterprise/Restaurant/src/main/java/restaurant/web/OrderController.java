package restaurant.web;

import restaurant.model.Order;
import restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @RequestMapping(value = "/admin/getAllOrders", method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @RequestMapping(value = "/admin/order/opened", method = RequestMethod.GET)
    public List<Order> getAllOpenedOrders() {
        return orderService.findAllOpenedOrders();
    }

    @RequestMapping(value = "/admin/order/closed", method = RequestMethod.GET)
    public List<Order> getAllClosedOrders() {
        return orderService.findAllClosedOrders();
    }

    @RequestMapping(value = "/admin/order/{id}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
