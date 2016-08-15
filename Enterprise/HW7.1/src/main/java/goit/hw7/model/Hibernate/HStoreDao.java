package goit.hw7.model.Hibernate;

import goit.hw7.model.DaoInterfaces.StoreDao;
import goit.hw7.model.Store;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HStoreDao implements StoreDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Store store) {
        sessionFactory.getCurrentSession().save(store);

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void remove(Store store) {
        sessionFactory.getCurrentSession().remove(store);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void changeQuantityOfIngredients(String ingredientName, int quantity) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Store set quantity = :quantity where ingredient.name = :ingredientName");
        query.setParameter("quantity", quantity);
        query.setParameter("ingredientName", ingredientName);
        query.executeUpdate();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Store findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select s from Store s where s.ingredient.name = :name");
        query.setParameter("name", name);
        return (Store) query.uniqueResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Store> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select s from Store s").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Store> findEndsIngredients() {
        return sessionFactory.getCurrentSession().createQuery("select s from Store s where s.quantity < 10").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
