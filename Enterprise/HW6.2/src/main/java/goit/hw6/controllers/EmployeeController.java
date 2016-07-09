package goit.hw6.controllers;

import goit.hw6.model.Employee;
import goit.hw6.model.DaoInterfaces.EmployeeDao;
import org.springframework.transaction.annotation.*;

import java.util.List;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
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
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployeeById(id);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
