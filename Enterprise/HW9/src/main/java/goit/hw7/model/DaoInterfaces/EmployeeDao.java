package goit.hw7.model.DaoInterfaces;


import goit.hw7.model.Cook;
import goit.hw7.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    List<Employee> findByName(String name);

    void remove(Employee employee);

    void save(Employee employee);

    Employee getById(int id);
}
