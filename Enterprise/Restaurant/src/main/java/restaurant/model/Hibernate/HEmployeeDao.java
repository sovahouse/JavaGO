package restaurant.model.Hibernate;

import restaurant.model.DaoInterfaces.EmployeeDao;
import restaurant.model.Employee;
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
    public void saveOrUpdate(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Employee e where e.id = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findBySurname(String surname) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Employee e where e.surname like :surname");
        query.setParameter("surname", surname);
        return query.list();
    }

    @Override
    public List<Employee> findByNameSurname(String name, String surname) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Employee e where e.name like :name and e.surname like :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
