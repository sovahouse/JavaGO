package restaurant.model.Hibernate;

import restaurant.model.DaoInterfaces.OrderDao;
import restaurant.model.DaoInterfaces.StoreDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import restaurant.model.Dish;
import restaurant.model.Ingredient;
import restaurant.model.Order;

import java.util.ArrayList;
import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;
    private StoreDao storeDao;

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
        if (targetOrder.getDishes() == null ) {
            reserveIngredients(dish);
            List<Dish> dishes = new ArrayList<>();
            dishes.add(dish);
            targetOrder.setDishes(dishes);
            sessionFactory.getCurrentSession().saveOrUpdate(targetOrder);
        } else if (!targetOrder.getDishes().contains(dish) && targetOrder.isOpen()) {
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

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    private void releaseIngredients(Dish dish) {
        for (Ingredient ingredient : dish.getIngredients()) {
            int quantity = storeDao.findByIngredientsName(ingredient.getName()).getQuantity();
            storeDao.changeQuantityOfIngredients(ingredient.getName(), quantity + 1);
        }
    }

    private void reserveIngredients(Order order) {
        if (order.getDishes() != null) {
            for (Dish dish : order.getDishes()) {
                reserveIngredients(dish);
            }
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

}
