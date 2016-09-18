package restaurant.model.Hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import restaurant.model.DaoInterfaces.IngredientDao;
import restaurant.model.Ingredient;

import java.util.List;

public class HIngredientDao implements IngredientDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Ingredient> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select i from Ingredient i").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void createOrUpdate(Ingredient ingredient) {
        sessionFactory.getCurrentSession().saveOrUpdate(ingredient);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
