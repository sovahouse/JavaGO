package goit.hw6.controllers;

import goit.hw6.model.DaoInterfaces.OrderDao;

public class OrderController {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
