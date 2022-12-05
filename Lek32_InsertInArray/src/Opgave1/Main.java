package Opgave1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Peter","Lang",7000,"Aarhus");
        Customer c2 = new Customer("Lars","Vand",7000,"Esbjerg");
        Customer c3 = new Customer("Soeren","Tro",2000,"Odense");
        Customer c4 = new Customer("Bo","Vej",7000,"Aarhus");

        Customer[] customers = new Customer[10];

        SortedArrayCustomer.insertCustomer(customers,c1);
        SortedArrayCustomer.insertCustomer(customers,c2);
        SortedArrayCustomer.insertCustomer(customers,c3);
        SortedArrayCustomer.insertCustomer(customers,c4);

        System.out.println(Arrays.toString(customers));


    }

}
