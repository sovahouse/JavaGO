package goit.hw6.model;

public class Store {

    private Ingredient ingredient;
    private int quantity;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Store{" +
                "ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}
