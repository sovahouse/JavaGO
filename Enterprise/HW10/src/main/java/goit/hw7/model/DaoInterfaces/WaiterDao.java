package goit.hw7.model.DaoInterfaces;

import goit.hw7.model.Waiter;

public interface WaiterDao extends EmployeeDao {
    Waiter getById(int id);
}
