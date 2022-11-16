package Application.Controller;

import Application.Model.Customer;
import Storage.CustomerStorage;

import java.util.ArrayList;

public class CustomerController {

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(CustomerStorage.getAll());
    }
}
