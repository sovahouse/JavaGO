package restaurant.service;

import restaurant.model.Employee;
import restaurant.model.DaoInterfaces.EmployeeDao;
import org.springframework.transaction.annotation.*;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteEmployee(Employee employee) {
        employeeDao.remove(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getEmployeeBySurname(String surname) {
        return employeeDao.findBySurname(surname);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getEmployeeByNameSurname(String name, String surname) {
        return employeeDao.findByNameSurname(name, surname);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
