package goit.hw7.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ord")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "open_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private Waiter waiter;

    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook;

    @OneToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "dish_to_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "prepared_dish_to_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "prepared_dish_id")
    )
    private List<PreparedDish> preparedDishes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<PreparedDish> getPreparedDishes() {
        return preparedDishes;
    }

    public void setPreparedDishes(List<PreparedDish> preparedDishes) {
        this.preparedDishes = preparedDishes;
    }

    public boolean isOpen() {
        return status;
    }

    public void setOpenStatus(boolean isOpen) {
        this.status = isOpen;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }
}
