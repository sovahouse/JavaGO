package goit.hw6.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Dish {

    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private List<Ingredient> ingredients;
    @Getter @Setter private String category;
    @Getter @Setter private double price;
    @Getter @Setter private double weight;

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
