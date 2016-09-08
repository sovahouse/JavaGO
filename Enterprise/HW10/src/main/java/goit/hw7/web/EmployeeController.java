package goit.hw7.web;


import goit.hw7.model.Employee;
import goit.hw7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<EmployeeNameAndSurname> employees() {
        List<EmployeeNameAndSurname> result = new ArrayList<>();
        for (Employee employee: employeeService.getAllEmployees()) {
            result.add(new EmployeeNameAndSurname(employee.getName(), employee.getSurname()));
        }
        return result;
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

    private class EmployeeNameAndSurname {
        private String name;
        private String surname;

        public EmployeeNameAndSurname(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }
}
