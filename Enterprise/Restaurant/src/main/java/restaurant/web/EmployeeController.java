package restaurant.web;


import restaurant.model.Employee;
import restaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/admin/employees", method = RequestMethod.GET)
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

    @RequestMapping(value = "/admin/employees/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }

    @RequestMapping(value = "/employees/createOrUpdate", method = RequestMethod.POST)
    public void createOrUpdate(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.createOrUpdateEmployee(employee);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
