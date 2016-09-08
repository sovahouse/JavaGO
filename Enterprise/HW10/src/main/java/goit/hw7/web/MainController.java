package goit.hw7.web;

import goit.hw7.model.Employee;
import goit.hw7.model.Order;
import goit.hw7.service.DishService;
import goit.hw7.service.EmployeeService;
import goit.hw7.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;


@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
