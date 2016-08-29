package goit.hw7.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee {

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<PreparedDish> preparedDishes;

}
