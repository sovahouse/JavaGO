package goit.hw6.controllers;

import goit.hw6.model.Employee;
import goit.hw6.model.EmployeeDao;
import org.springframework.transaction.annotation.*;

import java.util.List;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getAllEmployees() {
       return employeeDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
