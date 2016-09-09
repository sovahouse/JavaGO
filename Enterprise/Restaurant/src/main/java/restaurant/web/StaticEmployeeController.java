package restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import restaurant.model.Employee;

@Controller
public class StaticEmployeeController {

    EmployeeController employeeController;

    @RequestMapping(value = "/stuff", method = RequestMethod.GET)
    public String stuff() {
        return "redirect:/static/stuff.html";
    }

    @Autowired
    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
