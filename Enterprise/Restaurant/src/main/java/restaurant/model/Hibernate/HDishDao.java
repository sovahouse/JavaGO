package restaurant.model.Hibernate;

import restaurant.model.DaoInterfaces.DishDao;
import restaurant.model.Dish;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import restaurant.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select d from Dish d where d.name = :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().remove(dish);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void createOrUpdate(Dish dish) {
        sessionFactory.getCurrentSession().saveOrUpdate(dish);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select d from Dish d where d.id = :id");
        query.setParameter("id", id);
        return (Dish) query.uniqueResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteIngredientFromAllDishes(Ingredient ingredient) {
        List<Dish> result = new ArrayList<>();
        for (Dish dish : findAll()) {
            for (Ingredient i : dish.getIngredients()) {
                if (ingredient.equals(i)) {
                    result.add(dish);
                }
            }
        }

        for (Dish dish : result) {
            deleteIngredient(ingredient, dish);
        }
    }

    private void deleteIngredient(Ingredient ingredient, Dish dish) {
        dish.getIngredients().remove(ingredient);
        sessionFactory.getCurrentSession().saveOrUpdate(dish);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
