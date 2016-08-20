package goit.hw7.model.Hibernate;

import goit.hw7.model.DaoInterfaces.OrderDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Order;
import goit.hw7.model.PreparedDish;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

public class HOrderDao implements OrderDao { //TODO: testing

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addOrder(Order order) {
        order.setOpenStatus(true);
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Order getById(int id) {
        Query query =sessionFactory.getCurrentSession().createQuery("select o from Order o where o.id = :id");
        query.setParameter("id", id);
        return (Order) query.uniqueResult();
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDish(Dish dish, Order targetOrder) {
        if (!targetOrder.getDishes().contains(dish) && targetOrder.isOpen()) {
            targetOrder.getDishes().add(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(targetOrder);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDish(Dish dish, Order targetOrder) {
        if (targetOrder.isOpen()) {
            targetOrder.getDishes().remove(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(targetOrder);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delete(Order order) {
        if (order.isOpen()) {
            sessionFactory.getCurrentSession().remove(order);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void closeOrder(Order order) { //TODO: testing!!!
        order.setOpenStatus(false);
        List<PreparedDish> preparedDishList = new LinkedList<>();
        for (Dish dish:order.getDishes()) {
            PreparedDish preparedDish = new PreparedDish();
            preparedDish.setDish(dish);
            preparedDish.setDate(order.getDate());
            preparedDish.setEmployee(order.getEmployee());

            preparedDishList.add(preparedDish);
        }
        order.setPreparedDishes(preparedDishList);
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findAllOpenedOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.status = true").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findAllClosedOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.status = false").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
