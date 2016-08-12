package goit.hw7.model;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @OneToOne
    @Column(name = "ingredient_name")
    private Ingredient ingredient;

    @Column(name = "quantity")
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
