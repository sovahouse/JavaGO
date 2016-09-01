package goit.hw7.model.Hibernate;

import goit.hw7.model.*;
import goit.hw7.model.DaoInterfaces.CookDao;
import goit.hw7.model.DaoInterfaces.OrderDao;
import goit.hw7.model.DaoInterfaces.PreparedDishDao;
import goit.hw7.model.DaoInterfaces.StoreDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;
    private StoreDao storeDao;
    private CookDao cookDao;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addOrder(Order order) {
        order.setOpenStatus(true);
        reserveIngredients(order);
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Order getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select o from Order o where o.id = :id");
        query.setParameter("id", id);
        return (Order) query.uniqueResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDish(Dish dish, Order targetOrder) {
        if (!targetOrder.getDishes().contains(dish) && targetOrder.isOpen()) {
            reserveIngredients(dish);
            targetOrder.getDishes().add(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(targetOrder);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDish(Dish dish, Order targetOrder) {
        if (targetOrder.isOpen()) {
            releaseIngredients(dish);
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
    public void closeOrder(Order order) {
        order.setOpenStatus(false);

        for (Dish dish : order.getDishes()) {
            prepareDish(dish, order);
        }

        sessionFactory.getCurrentSession().saveOrUpdate(order);

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void prepareDish(Dish dish, Order targetOrder) {
        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setDish(dish);
        preparedDish.setDate(targetOrder.getDate());
        preparedDish.setEmployee(targetOrder.getCook());

        cookDao.addPreparedDish(preparedDish, targetOrder.getCook());

        targetOrder.getDishes().remove(dish);

        List<PreparedDish> preparedDishesList = targetOrder.getPreparedDishes();
        if (preparedDishesList == null) { preparedDishesList = new ArrayList<>();}

        preparedDishesList.add(preparedDish);
        targetOrder.setPreparedDishes(preparedDishesList);

        sessionFactory.getCurrentSession().saveOrUpdate(targetOrder);
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

    private void releaseIngredients(Dish dish) {
        for (Ingredient ingredient : dish.getIngredients()) {
            int quantity = storeDao.findByIngredientsName(ingredient.getName()).getQuantity();
            storeDao.changeQuantityOfIngredients(ingredient.getName(), quantity + 1);
        }
    }

    private void reserveIngredients(Order order) {
        for (Dish dish : order.getDishes()) {
            reserveIngredients(dish);
        }
    }

    private void reserveIngredients(Dish dish) {
        for (Ingredient ingredient : dish.getIngredients()) {
            int quantity = storeDao.findByIngredientsName(ingredient.getName()).getQuantity();
            if (quantity < 1) {
                //TODO: add exception
            }
            storeDao.changeQuantityOfIngredients(ingredient.getName(), quantity - 1);
        }
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public void setCookDao(CookDao cookDao) {
        this.cookDao = cookDao;
    }
}
