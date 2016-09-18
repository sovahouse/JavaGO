package restaurant.model.Hibernate;

import restaurant.model.DaoInterfaces.DishDao;
import restaurant.model.Dish;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select d from Dish d where d.name = :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().remove(dish);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void createOrUpdate(Dish dish) {
        sessionFactory.getCurrentSession().saveOrUpdate(dish);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select d from Dish d where d.id = :id");
        query.setParameter("id", id);
        return (Dish) query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
