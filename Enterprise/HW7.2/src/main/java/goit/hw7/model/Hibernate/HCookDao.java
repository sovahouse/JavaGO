package goit.hw7.model.Hibernate;

import goit.hw7.model.Cook;
import goit.hw7.model.DaoInterfaces.CookDao;
import goit.hw7.model.PreparedDish;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class HCookDao extends HEmployeeDao implements CookDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Cook getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select c from Cook c where c.id = :id");
        query.setParameter("id", id);
        return (Cook) query.uniqueResult();
    }

    @Override
    public void addPreparedDish(PreparedDish preparedDish, Cook cook) {
        List<PreparedDish> preparedDishesList = cook.getPreparedDishes();
        if (preparedDishesList == null) { preparedDishesList = new ArrayList<>();}

        preparedDishesList.add(preparedDish);

        cook.setPreparedDishes(preparedDishesList);

        sessionFactory.getCurrentSession().saveOrUpdate(cook);
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
