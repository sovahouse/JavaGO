package goit.hw6.model;

import java.time.LocalDate;

public class PreparedDish {
    private int id;
    private int employeeId;
    private int dishId;
    private int orderId;
    private int dishesNumber;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishesNumber() {
        return dishesNumber;
    }

    public void setDishesNumber(int dishesNumber) {
        this.dishesNumber = dishesNumber;
    }
}
