package goit.hw7.model;

import java.time.LocalDate;

public class Order {

    private int id;
    private int tableNumber;
    private LocalDate date;
    private Employee employee;
    private Dish dish;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                ", date=" + date +
                ", employee=" + employee +
                ", dish=" + dish +
                '}';
    }
}
