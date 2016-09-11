package restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:/static/index.html";
    }

    @RequestMapping(value = "dishes/dishdetail", method = RequestMethod.GET)
    public String dishdetail() {
        return "redirect:/static/dishdetail.html";
    }

    @RequestMapping(value = "/ourstuff", method = RequestMethod.GET)
    public String ourstuff() {
        return "redirect:/static/ourstuff.html";
    }

    @RequestMapping(value = "/ourcontacts", method = RequestMethod.GET)
    public String ourContacts() {
        return "redirect:/static/ourcontacts.html";
    }

    @RequestMapping(value = "/schemeofrestaurant", method = RequestMethod.GET)
    public String schemeOfRestaurant() {
        return "redirect:/static/schemeofrestaurant.html";
    }


}
