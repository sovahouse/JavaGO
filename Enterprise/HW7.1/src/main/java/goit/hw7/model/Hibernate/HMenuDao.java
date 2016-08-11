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
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void remove(Menu menu) {
        sessionFactory.getCurrentSession().remove(menu);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDish(Dish dish, Menu targetMenu) {
        /*Query query = sessionFactory.getCurrentSession().createQuery("delete from Menu.dishes d where Menu.name = :name and d.id = :id"); //TODO: redoing
        query.setParameter("id", dish.getId());
        query.setParameter("name", targetMenu.getName());*/
        /*for (Dish d: targetMenu.getDishes()) {
            if (dish.equals(d)) {
                targetMenu.getDishes().remove(d);
            }
        }*/
        targetMenu.getDishes().remove(0);
        sessionFactory.getCurrentSession().saveOrUpdate(targetMenu);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDish(Dish dish, Menu targetMenu) {
        //TODO: add this method
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Menu getByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.name = :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Menu> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
