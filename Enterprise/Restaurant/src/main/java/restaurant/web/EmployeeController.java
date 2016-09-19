package restaurant.web;


import restaurant.model.Employee;
import restaurant.model.Position;
import restaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/admin/employees", method = RequestMethod.GET)
    public List<Employee> employees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<EmployeeForClient> employeesForClient() {
        List<EmployeeForClient> result = new ArrayList<>();
        for (Employee employee: employeeService.getAllEmployees()) {
            //result.add(new EmployeeForClient(employee.getName(), employee.getPhoto(), employee.getPosition()));
        }
        return result;
    }

    @RequestMapping(value = "/admin/employees/id={id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @RequestMapping(value = "/admin/employees/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }

    @RequestMapping(value = "/admin/employees/createOrUpdate", method = RequestMethod.POST)
    public void createOrUpdate(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.createOrUpdateEmployee(employee);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private class EmployeeForClient {
        private String name;
        private String photo;
        private Position position;

        EmployeeForClient(String name, String photo, Position position) {
            this.name = name;
            this.photo = photo;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }
    }
}
