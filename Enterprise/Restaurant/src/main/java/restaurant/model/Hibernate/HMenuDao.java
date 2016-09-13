package restaurant.model.Hibernate;

import restaurant.model.DaoInterfaces.MenuDao;
import restaurant.model.Dish;
import restaurant.model.Menu;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        targetMenu.getDishes().remove(dish);
        sessionFactory.getCurrentSession().saveOrUpdate(targetMenu);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDish(Dish dish, Menu targetMenu) {
        if (!targetMenu.getDishes().contains(dish)) {
            targetMenu.getDishes().add(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(targetMenu);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDishFromAllMenus(Dish dish) {
        List<Menu> result = new ArrayList<>();
        for (Menu menu : findAll()) {
            for (Dish d : menu.getDishes()) {
                if (dish.equals(d)) {
                    result.add(menu);
                }
            }
        }

        for (Menu menu : result) {
            deleteDish(dish, menu);
        }
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
    public Menu getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.id = :id");
        query.setParameter("id", id);
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
