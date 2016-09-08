package restaurant.web;

import restaurant.model.Menu;
import restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class MenuController {

    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<String> menus(){
        List<String> result = new ArrayList<>();
        for (Menu menu:menuService.findAll()) {
            result.add(menu.getName());
        }
        return result;
    }

    @RequestMapping(value = "/menu/id={id}", method = RequestMethod.GET)
    public Menu getById(@PathVariable int id) {
        return menuService.getById(id);
    }

    @RequestMapping(value = "/menu/name={name}", method = RequestMethod.GET)
    public Menu getByName(@PathVariable String name) {
        return menuService.getByName(name);
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
