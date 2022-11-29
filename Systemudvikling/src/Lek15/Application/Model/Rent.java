package Lek15.Application.Model;

public class Rent {
    private int days;
    private Car car;
    private Customer customer;

    public Rent(int days, Car car, Customer customer) {
        this.days = days;
        this.car = car;
        this.customer = customer;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int totalPrice() {
        return car.getCarType().getPricePerDay() * days;
    }
}
