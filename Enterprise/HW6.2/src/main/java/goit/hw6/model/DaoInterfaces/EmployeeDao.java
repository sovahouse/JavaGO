package goit.hw6.model.DaoInterfaces;


import goit.hw6.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    List<Employee> findByName(String name);
}