package restaurant.model.Hibernate;

import restaurant.model.DaoInterfaces.StoreDao;
import restaurant.model.Store;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HStoreDao implements StoreDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void createOrUpdate(Store store) {
        sessionFactory.getCurrentSession().saveOrUpdate(store);

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void remove(Store store) {
        sessionFactory.getCurrentSession().remove(store);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void changeQuantityOfIngredients(int ingredientId, int quantity) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Store set quantity = :quantity where ingredient.id = :ingredientId");
        query.setParameter("quantity", quantity);
        query.setParameter("ingredientId", ingredientId);
        query.executeUpdate();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Store findByIngredientsName(String name) {
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

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Store getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select s from Store s where s.id = :id");
        query.setParameter("id", id);
        return (Store) query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
