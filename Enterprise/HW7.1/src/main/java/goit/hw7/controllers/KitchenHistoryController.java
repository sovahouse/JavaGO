package goit.hw7.controllers;

import goit.hw7.model.DaoInterfaces.PreparedDishDao;
import goit.hw7.model.PreparedDish;
import goit.hw7.model.jdbc.JdbcPreparedDishDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class KitchenHistoryController {

    private PreparedDishDao preparedDishDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addPreparedDishes(PreparedDish preparedDish){
        preparedDishDao.addPreparedDish(preparedDish);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<PreparedDish> findAll() {
        return preparedDishDao.findAll();
    }

    public void setPreparedDishDao(JdbcPreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }

}
