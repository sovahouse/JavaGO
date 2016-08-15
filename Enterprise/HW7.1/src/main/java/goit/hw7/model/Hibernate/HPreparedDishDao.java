package goit.hw7.model.Hibernate;

import goit.hw7.model.DaoInterfaces.PreparedDishDao;
import goit.hw7.model.PreparedDish;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HPreparedDishDao implements PreparedDishDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<PreparedDish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select pd from PreparedDish pd").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void create(PreparedDish preparedDish) {
        sessionFactory.getCurrentSession().save(preparedDish);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
