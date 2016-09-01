package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Cook;

public interface CookDao extends EmployeeDao {
    Cook getById(int id);
}
