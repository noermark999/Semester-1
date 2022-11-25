package Lek16.Storage;

import Lek16.Application.Model.Car;
import Lek16.Application.Model.CarType;
import Lek16.Application.Model.Customer;
import Lek16.Application.Model.Rent;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Car> cars = new ArrayList<>();
    private static final ArrayList<Customer> customers = new ArrayList<>();
    private static final ArrayList<Rent> rents = new ArrayList<>();

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(customers);
    }
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public static void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public static ArrayList<Car> getCars() {
        return new ArrayList<Car>(cars);
    }

    public static void addCar(Car car) {
        cars.add(car);
    }

    public static ArrayList<Rent> getRents() {
        return new ArrayList<Rent>(rents);
    }

    public static void addRent(Rent rent) {
        rents.add(rent);
    }
}
