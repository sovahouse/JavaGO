package goit.hw7.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany()
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "menu_list",
            joinColumns = @JoinColumn(name = "menu"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
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
