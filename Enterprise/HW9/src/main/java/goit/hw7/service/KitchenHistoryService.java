package goit.hw7.service;

import goit.hw7.model.DaoInterfaces.PreparedDishDao;
import goit.hw7.model.PreparedDish;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class KitchenHistoryService {

    private PreparedDishDao preparedDishDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<PreparedDish> findAll() {
        return preparedDishDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(PreparedDish preparedDish) {
        preparedDishDao.create(preparedDish);
    }

    public void setPreparedDishDao(PreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }
}
