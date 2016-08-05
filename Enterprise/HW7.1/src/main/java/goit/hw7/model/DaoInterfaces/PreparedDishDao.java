package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.PreparedDish;

import java.util.List;

public interface PreparedDishDao {

    List<PreparedDish> findAll();
    void addPreparedDish(PreparedDish preparedDish);

}
