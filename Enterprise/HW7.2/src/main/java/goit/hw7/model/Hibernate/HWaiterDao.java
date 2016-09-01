package goit.hw7.model.Hibernate;

import goit.hw7.model.DaoInterfaces.WaiterDao;
import goit.hw7.model.Waiter;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class HWaiterDao extends HEmployeeDao implements WaiterDao{

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Waiter getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select w from Waiter w where w.id = :id");
        query.setParameter("id", id);
        return (Waiter) query.uniqueResult();
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
