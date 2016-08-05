package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Dish;
import goit.hw7.model.Order;

import java.util.List;

public interface OrderDao {

    void addOrder(Order order);
    Order getById(int id);
    void addDish(Dish dish, int orderId);
    void deleteDish(Dish dish, int orderId);
    void deleteOrderById(int id);
    void closeOrder(int id);
    List<Order> findAllOpenOrders();
    List<Order> findAllClosedOrders();
}
