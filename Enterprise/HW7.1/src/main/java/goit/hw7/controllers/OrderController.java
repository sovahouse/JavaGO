package goit.hw7.controllers;

import goit.hw7.model.DaoInterfaces.OrderDao;
import goit.hw7.model.DaoInterfaces.PreparedDishDao;
import goit.hw7.model.Order;
import goit.hw7.model.PreparedDish;

public class OrderController {

    private OrderDao orderDao;
    private PreparedDishDao preparedDishDao;

    public void closeOrder(Order order){
        orderDao.closeOrder(order);

    }

}
