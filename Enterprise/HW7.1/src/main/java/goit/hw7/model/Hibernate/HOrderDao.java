package goit.hw7.model.Hibernate;

import goit.hw7.model.DaoInterfaces.OrderDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Order;
import org.hibernate.SessionFactory;

import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public void addDish(Dish dish, int orderId) {

    }

    @Override
    public void deleteDish(Dish dish, int orderId) {

    }

    @Override
    public void deleteOrderById(int id) {

    }

    @Override
    public void closeOrder(int id) {

    }

    @Override
    public List<Order> findAllOpenOrders() {
        return null;
    }

    @Override
    public List<Order> findAllClosedOrders() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
