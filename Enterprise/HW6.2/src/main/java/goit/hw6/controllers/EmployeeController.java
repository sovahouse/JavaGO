package goit.hw6.controllers;

import goit.hw6.model.Employee;
import goit.hw6.model.EmployeeDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getAllEmployees() {
       return employeeDao.findAll();

    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
