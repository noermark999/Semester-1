package Lek16.Application.Controller;

import Lek16.Application.Model.Car;
import Lek16.Application.Model.CarType;
import Lek16.Application.Model.Customer;
import Lek16.Storage.Storage;

import java.util.ArrayList;

public class Controller {
    public static Car createCar(String color, int weight, String brand, CarType carType) {
        Car car = new Car(color, weight, brand, carType);
        Storage.addCar(car);
        return car;
    }

    public static ArrayList<Car> getCars() {
        return Storage.getCars();
    }

    public static void addCarToCartype(Car car, CarType carType){
        carType.addCar(car);
    }

    public static Customer createCustomer(String name, int age, long licenseID, long cprNR) {
        Customer customer = new Customer(name, age, licenseID, cprNR);
        Storage.addCustomer(customer);
        return customer;
    }

}
