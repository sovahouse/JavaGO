package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Dish;
import goit.hw7.model.Order;

import java.util.List;

public interface OrderDao {

    void addOrder(Order order);
    Order getById(int id);
    void addDish(Dish dish, Order targetOrder);
    void deleteDish(Dish dish, Order targetOrder);
    void delete(Order order);
    void closeOrder(Order order);
    List<Order> findAllOpenedOrders();
    List<Order> findAllClosedOrders();
    List<Order> findAllOrders();
}
