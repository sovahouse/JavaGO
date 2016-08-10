package goit.hw7.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "ingredients_for_dish",
            joinColumns = @JoinColumn(name = "ingredient_name"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Ingredient> ingredients;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;

    @Column(name = "weight")
    private double weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {

        StringBuilder ingredientsList = new StringBuilder();

        for (Ingredient ingredient: ingredients) {
            ingredientsList.append(ingredient.getName() + ", ");
        }

        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients= " + "\"" + ingredientsList + "\"" +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
