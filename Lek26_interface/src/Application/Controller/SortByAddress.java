package Application.Controller;

import Application.Model.Customer;

import java.util.Comparator;

public class SortByAddress implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        String[] address1 = o1.getStreet().split(" ",2);
        String[] address2 = o2.getStreet().split(" ",2);
        if (!o1.getTown().equals(o2.getTown())) {
            return o1.getTown().compareTo(o2.getTown());
        } else if (!o1.getZip().equals(o2.getZip())) {
            return o1.getZip().compareTo(o2.getZip());
        }
        return address1[1].compareTo(address2[1]);
    }
}
