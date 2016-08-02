package goit.hw6.controllers;

import goit.hw6.model.DaoInterfaces.OrderDao;
import goit.hw6.model.Dish;
import goit.hw6.model.Order;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderController {

    private OrderDao orderDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDish(Dish dish, int orderId) {
        orderDao.addDish(dish, orderId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDish(Dish dish, int orderId) {
        orderDao.deleteDish(dish, orderId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOrder(int id) {
        orderDao.deleteOrderById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> findAllOpenOrders() {
        return orderDao.findAllOpenOrders();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> findAllClosedOrders() {
        return orderDao.findAllClosedOrders();
    }

    public void closeOrder(int id) {
        orderDao.closeOrder(id);
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
