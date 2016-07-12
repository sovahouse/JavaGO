package goit.hw6.controllers;

import goit.hw6.model.PreparedDish;
import goit.hw6.model.jdbc.JdbcPreparedDishDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class KitchenHistoryController {

    private JdbcPreparedDishDao jdbcPreparedDishDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addPreparedDishes(PreparedDish preparedDish){

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<PreparedDish> findAll() {
        return jdbcPreparedDishDao.findAll();
    }

    public void setJdbcPreparedDishDao(JdbcPreparedDishDao jdbcPreparedDishDao) {
        this.jdbcPreparedDishDao = jdbcPreparedDishDao;
    }

}
