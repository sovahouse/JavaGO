package goit.hw7.model.Hibernate;

import goit.hw7.model.DaoInterfaces.DishDao;
import goit.hw7.model.Dish;
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
    public List<Dish> findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select d from Dish d where d.name = :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().remove(dish);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
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
