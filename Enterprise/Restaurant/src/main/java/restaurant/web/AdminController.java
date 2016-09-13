package restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AdminController {

    @RequestMapping(value = {"/admin", "admin/index"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:/static/adminSide/index.html";
    }

    @RequestMapping(value = "/static/adminSide", method = RequestMethod.GET)
    public String admin() {
        return "redirect:/static/adminSide/index.html";
    }

    @RequestMapping(value = "/admin/stuff", method = RequestMethod.GET)
    public String stuff() {
        return "redirect:/static/adminSide/stuff.html";
    }

    @RequestMapping(value = "/admin/employee/edit", method = RequestMethod.GET)
    public String editEmployee() {
        return "redirect:/static/adminSide/editEmployee.html";
    }

    @RequestMapping(value = "/admin/dishes", method = RequestMethod.GET)
    public String dishes() {
        return "redirect:/static/adminSide/dishes.html";
    }

    @RequestMapping(value = "/admin/menu", method = RequestMethod.GET)
    public String menus() {
        return "redirect:/static/adminSide/menu.html";
    }

    @RequestMapping(value = "/admin/store", method = RequestMethod.GET)
    public String store() {
        return "redirect:/static/adminSide/store.html";
    }

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public String orders() {
        return "redirect:/static/adminSide/orders.html";
    }
}
