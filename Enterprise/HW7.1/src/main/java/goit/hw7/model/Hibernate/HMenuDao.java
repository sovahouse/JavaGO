package goit.hw7.model.Hibernate;

import goit.hw7.model.DaoInterfaces.MenuDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Menu;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HMenuDao implements MenuDao {

    private SessionFactory sessionFactory;

    @Override
    public void addMenu(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    public void remove(Menu menu) {
        sessionFactory.getCurrentSession().remove(menu);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDish(Dish dish, Menu targetMenu) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Menu where Menu.name = :name and Dish.id = :id"); //TODO: redoing
        query.setParameter("id", dish.getId());
        query.setParameter("name", targetMenu.getName());
    }

    @Override
    public void addDish(Dish dish, Menu targetMenu) {

    }

    @Override
    public Menu getByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.name = :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    public List<Menu> findAll() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
