package minihandel;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Product kaffe = new Product(1,"Kaffe",50);
        Product soda = new Product(2,"Sodavand", 14);
        Product banan = new Product(3,"Banan",3.5);
        Product vindruer = new Product(4,"Vindruer",20);
        Product fjernsyn = new Product(5,"Fjernsyn",1500);

        LocalDate localDate1 = LocalDate.of(2001,3,24);
        LocalDate localDate2 = LocalDate.of(2005,8,10);

        Customer lars = new Customer("Lars",localDate1);
        Customer peter = new Customer("Peter",localDate2);

        Order order1 = new Order(1);
        order1.createOrderLine(1,kaffe);
        order1.createOrderLine(2,soda);
        lars.addOrder(order1);

        Order order2 = new Order(2);
        order2.createOrderLine(4,banan);
        order2.createOrderLine(1,fjernsyn);
        lars.addOrder(order2);

        Order order3 = new Order(3);
        order3.createOrderLine(2,kaffe);
        order3.createOrderLine(1,vindruer);
        peter.addOrder(order3);

        Order order4 = new Order(4);
        order4.createOrderLine(1,kaffe);
        order4.createOrderLine(4,soda);
        peter.addOrder(order4);

        Order order5 = new Order(5);
        order5.createOrderLine(2,vindruer);
        order5.createOrderLine(10,banan);
        peter.addOrder(order5);

        Order order6 = new Order(6);
        order6.createOrderLine(3,kaffe);
        order6.createOrderLine(1,fjernsyn);
        peter.addOrder(order6);

        PercentDiscount percentDiscount = new PercentDiscount(15);
        FixedDiscount fixedDiscount = new FixedDiscount(250);

        lars.setDiscount(percentDiscount);
        peter.setDiscount(fixedDiscount);

        System.out.println("Fuld pris lars: " + lars.totalBuy());
        System.out.println("Pris med rabat lars: " +lars.totalBuyWithDiscount());
        System.out.println("--------------------------------------");
        System.out.println("Fuld pris peter: " + peter.totalBuy());
        System.out.println("Pris med rabat Peter: " + peter.totalBuyWithDiscount());

    }
}
