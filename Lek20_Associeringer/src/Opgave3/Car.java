package Opgave3;

import java.util.ArrayList;

public class Car {
    private String license;
    private double pricePerDay;
    private int purcaseYear;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String license, int year) {
        this.license = license;
        this.purcaseYear = year;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurcaseYear() {
        return purcaseYear;
    }
}
