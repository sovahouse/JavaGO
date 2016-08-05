package goit.hw6.model.DaoInterfaces;

import goit.hw6.model.PreparedDish;

import java.util.List;

public interface PreparedDishDao {

    List<PreparedDish> findAll();
    void addPreparedDish(PreparedDish preparedDish);

}
