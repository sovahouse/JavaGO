package goit.hw7.controllers;

import goit.hw7.model.Cook;
import goit.hw7.model.Employee;
import goit.hw7.model.DaoInterfaces.EmployeeDao;
import org.springframework.transaction.annotation.*;

import java.util.List;

public class EmployeeController {

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

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
