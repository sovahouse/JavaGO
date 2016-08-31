package goit.hw7.model.Hibernate;

import goit.hw7.model.Cook;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class HCookDao extends HEmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Cook getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select c from Cook c where c.id = :id");
        query.setParameter("id", id);
        return (Cook) query.uniqueResult();
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
