package restaurant.model.DaoInterfaces;


import restaurant.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    List<Employee> findByName(String name);

    void remove(Employee employee);

    void saveOrUpdate(Employee employee);

    Employee getById(int id);

    List<Employee> findBySurname(String surname);

    Employee findByNameSurname(String name, String surname);
}
