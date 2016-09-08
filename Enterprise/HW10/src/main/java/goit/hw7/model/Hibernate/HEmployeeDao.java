package goit.hw7.model.Hibernate;

import goit.hw7.model.Cook;
import goit.hw7.model.DaoInterfaces.EmployeeDao;
import goit.hw7.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().remove(employee);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Employee e where e.id = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
