package goit.hw6.model;


import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    List<Employee> findByName(String name);
}
