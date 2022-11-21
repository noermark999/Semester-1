package Opgave3.Application.Controller;

import Opgave3.Application.Model.Customer;

import java.util.Comparator;

public class SortByName implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        System.out.println(o1.getName().compareTo(o2.getName()));
        return o1.getName().compareTo(o2.getName());
    }
}
