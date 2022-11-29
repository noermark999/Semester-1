package Lek15.Application.Controller;

import Lek15.Application.Model.Car;
import Lek15.Application.Model.CarType;
import Lek15.Application.Model.Customer;
import Lek15.Storage.Storage;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Controller {
    public static Car createCar(String color, int weight, String brand, CarType carType) {
        Car car = new Car(color, weight, brand, carType);
        addCarToCartype(car,carType);
        Storage.addCar(car);
        return car;
    }

    public static ArrayList<Car> getCars(CarType carType) {
        ArrayList<Car> cars = new ArrayList<>(Storage.getCars());
        ArrayList<Car> cars1 = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarType().equals(carType)) {
                cars1.add(car);
            }
        }
        return cars1;
    }

    public static void addCarToCartype(Car car, CarType carType){
        carType.addCar(car);
    }

    public static Customer createCustomer(String name, int age, long licenseID, long cprNR) {
        Customer customer = new Customer(name, age, licenseID, cprNR);
        Storage.addCustomer(customer);
        return customer;
    }

    public static ArrayList<Customer> getCustomers() {
        return Storage.getCustomers();
    }

    private static CarType createCarType(CarType.Type type, int price) {
        CarType carType = new CarType(type,price);
        return carType;
    }

    public static void initStorage() {
        CarType a = createCarType(CarType.Type.A,10000);
        CarType b = createCarType(CarType.Type.B,7500);
        CarType c = createCarType(CarType.Type.C,5000);
        CarType d = createCarType(CarType.Type.D,2500);
    }

}
