package goit.hw7.model;

import java.util.List;

public class Menu {

    private String name;
    private List<Dish> dishes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {

        StringBuilder dishesList = new StringBuilder();

        for (Dish dish: dishes) {
            dishesList.append(dish.getName() + ", ");
        }

        return "Menu{" +
                "name='" + name + '\'' +
                ", dishes=" + "\"" + dishesList + "\"" +
                '}';
    }
}
