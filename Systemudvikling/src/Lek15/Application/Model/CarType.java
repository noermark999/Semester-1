package Lek15.Application.Model;

import java.util.ArrayList;

public class CarType {
    private enum Type {A,B,C,D}
    private Type type;
    private int PricePerDay;
    private ArrayList<Car> cars = new ArrayList<>();

    public CarType(Type type, int pricePerDay) {
        this.type = type;
        PricePerDay = pricePerDay;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPricePerDay() {
        return PricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        PricePerDay = pricePerDay;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
