package goit.hw7;

import goit.hw7.controllers.*;
import goit.hw7.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        /*List<Employee> employees = employeeController.getEmployeeByName("Alex");
        Employee alex = employees.get(0);
        employeeController.createEmployee(alex);*/
        Employee employee = new Employee();
        employee.setId(4);
        employeeController.deleteEmployee(employee);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }


}
