package goit.hw7.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cook extends Employee {

    @OneToMany(fetch=FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "prepared_dish_to_cook",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "prepared_dish_id")
    )
    private List<PreparedDish> preparedDishes;

    public List<PreparedDish> getPreparedDishes() {
        return preparedDishes;
    }

    public void setPreparedDishes(List<PreparedDish> preparedDishes) {
        this.preparedDishes = preparedDishes;
    }
}
