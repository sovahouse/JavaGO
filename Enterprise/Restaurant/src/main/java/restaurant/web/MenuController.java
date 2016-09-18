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

    @RequestMapping(value = "/admin/getAllMenu", method = RequestMethod.GET)
    public List<Menu> menu(){
        return menuService.findAll();
    }

    @RequestMapping(value = "/admin/menu/id={id}", method = RequestMethod.GET)
    public Menu getById(@PathVariable int id) {
        return menuService.getById(id);
    }

    @RequestMapping(value = "/admin/menu/name={name}", method = RequestMethod.GET)
    public Menu getByName(@PathVariable String name) {
        return menuService.getByName(name);
    }

    @RequestMapping(value = "/admin/menu/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Menu menu) {
        menuService.deleteMenu(menu);
    }

    @RequestMapping(value = "/admin/menu/createOrUpdate", method = RequestMethod.POST)
    public void createOrUpdate(@RequestBody Menu menu) {
        System.out.println(menu.toString());
        menuService.createOrUpdate(menu);
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
