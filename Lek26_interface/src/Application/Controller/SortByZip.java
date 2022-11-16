package Application.Controller;

import Application.Model.Customer;

import java.util.Comparator;

public class SortByZip implements Comparator<Customer> {
    public int compare(Customer o1, Customer o2) {
        return o1.getZip().compareTo(o2.getZip());
    }
}
