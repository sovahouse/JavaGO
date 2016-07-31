package goit.hw6.model.DaoInterfaces;

import goit.hw6.model.Order;

public interface OrderDao {

    void addOrder(Order order);

    Order getById(int id);
}
