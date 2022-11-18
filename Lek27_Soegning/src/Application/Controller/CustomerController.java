package Application.Controller;

import Application.Model.Customer;
import Storage.CustomerStorage;

import java.util.ArrayList;

public class CustomerController {

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(CustomerStorage.getAll());
    }

    public static ArrayList<Customer> filterByName(ArrayList<Customer> customers, String name) {
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(customer);
            } else if (customer.getZip().contains(name)) {
                list.add(customer);
            } else if (customer.getTown().toLowerCase().contains(name.toLowerCase())) {
                list.add(customer);
            } else if (customer.getStreet().toLowerCase().contains(name.toLowerCase())) {
                list.add(customer);
            } else if (customer.getCategory().toString().toLowerCase().equals(name.toLowerCase())) {
                list.add(customer);
            }
        }
        return list;
    }

    public static ArrayList<Customer> filterByCategory(ArrayList<Customer> customers, Customer.SizeCategory sizeCategory) {
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCategory().equals(sizeCategory)) {
                list.add(customer);
            }
        }
        return list;
    }
}
