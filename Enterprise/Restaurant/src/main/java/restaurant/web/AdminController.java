package restaurant.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class AdminController {

    @RequestMapping(value = {"/admin", "admin/index"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:/static/adminSide/index.html";
    }

    @RequestMapping(value = "/admin/stuff", method = RequestMethod.GET)
    public String stuff() {
        return "redirect:/static/adminSide/stuff.html";
    }

    @RequestMapping(value = "/admin/employee/edit", method = RequestMethod.GET)
    public String createOrUpdateEmployee() {
        return "redirect:/static/adminSide/createOrUpdatePages/createOrUpdateEmployee.html";
    }

    @RequestMapping(value = "/admin/dish/edit", method = RequestMethod.GET)
    public String createOrUpdateDish() {
        return "redirect:/static/adminSide/createOrUpdatePages/createOrUpdateDish.html";
    }

    @RequestMapping(value = "/admin/store/edit", method = RequestMethod.GET)
    public String createOrUpdateStore() {
        return "redirect:/static/adminSide/createOrUpdatePages/createOrUpdateStore.html";
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

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
