package Application.Controller;

import Application.Model.Customer;

import java.util.Comparator;

public class SortByCategory implements Comparator<Customer> {
    public int compare(Customer o1, Customer o2) {
        return o1.getCategory().ordinal() - o2.getCategory().ordinal();
    }
}
