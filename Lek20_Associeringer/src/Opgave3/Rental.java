package Opgave3;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars = new ArrayList<>();

    public Rental(int number, String date, int days) {
        this.number = number;
        this.date = date;
        this.days = days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
    public void addCar(Car car){
        if (!cars.contains(car)){
            cars.add(car);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public double getPrice() {
        double price = 0;
        for (var cars : cars) {
            price += cars.getPricePerDay();
        }
        return price * days;
    }
}
