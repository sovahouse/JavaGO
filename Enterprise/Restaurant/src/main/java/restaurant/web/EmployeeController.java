package restaurant.web;


import restaurant.model.Employee;
import restaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> employees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employees/id={id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @RequestMapping(value = "/employees/{name},{surname}", method = RequestMethod.GET)
    public List<Employee> getByNameSurname(@PathVariable String name, @PathVariable String surname) {
        if(name.isEmpty()) {
            return employeeService.getEmployeeBySurname(surname);
        } else if(surname.isEmpty()) {
            return employeeService.getEmployeeByName(name);
        } else {
            return employeeService.getEmployeeByNameSurname(name, surname);
        }
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
