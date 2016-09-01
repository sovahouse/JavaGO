package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Cook;
import goit.hw7.model.PreparedDish;

public interface CookDao extends EmployeeDao {
    Cook getById(int id);
    void addPreparedDish(PreparedDish preparedDish, Cook cook);
}
