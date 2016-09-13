package restaurant.web;

import org.springframework.web.bind.annotation.*;
import restaurant.model.Dish;
import restaurant.model.Menu;
import restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {

    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<Menu> menus(){
        return menuService.findAll();
    }

    @RequestMapping(value = "/menu/id={id}", method = RequestMethod.GET)
    public Menu getById(@PathVariable int id) {
        return menuService.getById(id);
    }

    @RequestMapping(value = "/menu/name={name}", method = RequestMethod.GET)
    public Menu getByName(@PathVariable String name) {
        return menuService.getByName(name);
    }

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Menu menu) {
        menuService.deleteMenu(menu);
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
