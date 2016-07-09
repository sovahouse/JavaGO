package goit.hw6.model;

import java.util.List;

public class Dish {

    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private String category;
    private double price;
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
