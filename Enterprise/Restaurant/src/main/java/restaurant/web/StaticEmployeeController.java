package restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticEmployeeController {

    @RequestMapping(value = "/stuff", method = RequestMethod.GET)
    public String stuff() {
        return "redirect:/static/stuff.html";
    }

}
