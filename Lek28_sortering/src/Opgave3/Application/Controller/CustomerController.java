package Opgave3.Application.Controller;

import Opgave3.Application.Model.Customer;
import Opgave3.Storage.CustomerStorage;

import java.util.ArrayList;

public class CustomerController {

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(CustomerStorage.getAll());
    }

    public static ArrayList<Customer> filterByName(ArrayList<Customer> customers, String name, Customer.SizeCategory sizeCategory) {
        ArrayList<Customer> list = new ArrayList<>();
        if (sizeCategory != null) {
            for (Customer customer : customers) {
                if (customer.getName().toLowerCase().contains(name.toLowerCase()) && customer.getCategory().equals(sizeCategory)) {
                    list.add(customer);
                } else if (customer.getZip().contains(name) && customer.getCategory().equals(sizeCategory)) {
                    list.add(customer);
                } else if (customer.getTown().toLowerCase().contains(name.toLowerCase()) && customer.getCategory().equals(sizeCategory)) {
                    list.add(customer);
                } else if (customer.getStreet().toLowerCase().contains(name.toLowerCase()) && customer.getCategory().equals(sizeCategory)) {
                    list.add(customer);
                } else if (customer.getCategory().toString().equalsIgnoreCase(name) && customer.getCategory().equals(sizeCategory)) {
                    list.add(customer);
                }
            }
        } else {
            for (Customer customer : customers) {
                if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                    list.add(customer);
                } else if (customer.getZip().contains(name)) {
                    list.add(customer);
                } else if (customer.getTown().toLowerCase().contains(name.toLowerCase())) {
                    list.add(customer);
                } else if (customer.getStreet().toLowerCase().contains(name.toLowerCase())) {
                    list.add(customer);
                } else if (customer.getCategory().toString().equalsIgnoreCase(name)) {
                    list.add(customer);
                }
            }
        }
        return list;
    }

    /*
    public static ArrayList<Customer> filterByCategory(ArrayList<Customer> customers, Customer.SizeCategory sizeCategory) {
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCategory().equals(sizeCategory)) {
                list.add(customer);
            }
        }
        return list;
    }

     */
}
