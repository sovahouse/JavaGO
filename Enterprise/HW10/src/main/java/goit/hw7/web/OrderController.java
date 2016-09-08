package goit.hw7.web;

import goit.hw7.model.Order;
import goit.hw7.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class OrderController {

    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
