package goit.hw7.service;

import goit.hw7.model.DaoInterfaces.OrderDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Order;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderService {

    private OrderDao orderDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void closeOrder(Order order){
        orderDao.closeOrder(order);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Order order) {
        orderDao.addOrder(order);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDish(Dish dish, Order targetOrder) {
        orderDao.addDish(dish, targetOrder);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDish(Dish dish, Order targetOrder) {
        orderDao.deleteDish(dish, targetOrder);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Order getById(int id) {
        return orderDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> findAllClosedOrders() {
        return orderDao.findAllClosedOrders();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> findAllOpenedOrders() {
        return orderDao.findAllOpenedOrders();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> findAllOrders() {
        return orderDao.findAllOrders();
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
