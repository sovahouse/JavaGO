package goit.hw7.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "prepared_dishes")
public class PreparedDish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "prepared_dish_to_order",
            joinColumns = @JoinColumn(name = "prepared_dish_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Dish> dishes;

    @OneToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(name = "dish_number")
    private int dishNumber;

    @Column(name = "date")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(int dishNumber) {
        this.dishNumber = dishNumber;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "id=" + id +
                ", employee=" + employee +
                ", dishes=" + dishes +
                ", dishNumber=" + dishNumber +
                ", date=" + date +
                '}';
    }
}
