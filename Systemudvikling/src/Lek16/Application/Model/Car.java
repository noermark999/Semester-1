package Lek16.Application.Model;

import java.util.ArrayList;

public class Car {
    private String color;
    private int weight;
    private String brand;
    private CarType carType;
    private ArrayList<Customer> customers;

    public Car(String color, int weight, String brand, CarType carType) {
        this.color = color;
        this.weight = weight;
        this.brand = brand;
        this.carType = carType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CarType getCarType() {
        return carType;
    }
}
