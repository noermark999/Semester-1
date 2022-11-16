package Application.Controller;

import Application.Model.Customer;

import java.util.Comparator;

public class SortByTown implements Comparator<Customer> {
    public int compare(Customer o1, Customer o2) {
        return o1.getTown().compareTo(o2.getTown());
    }
}
