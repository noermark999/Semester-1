import Application.Controller.Service;
import Application.Model.Bane;
import Application.Model.Medlem;
import Application.Model.Reservation;
import Storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public class test {
    public static void main(String[] args) {
        Bane bane = Service.createBane(1,"");
        Bane bane2 = Service.createBane(2,"");
        Medlem medlem1= new Medlem("Peter", "91837458", "peter@mail.com");
        Medlem medlem2= new Medlem("Lars", "84625967", "lars@mail.com");

        medlem1.createReservation(LocalDate.of(2021,10,10), LocalTime.of(10,0),medlem2,bane);

        //Test af opgave 2
        System.out.println(bane.isLedig(LocalDate.of(2021,9,10),LocalTime.of(10,0)));
        System.out.println(bane.isLedig(LocalDate.of(2021,10,10),LocalTime.of(10,0)));
        System.out.println(bane.isLedig(LocalDate.of(2021,11,10),LocalTime.of(10,0)));

        //test af opgave 3
        System.out.println(bane.getLedigeTiderPaaDag(LocalDate.of(2021,10,10)));
        System.out.println(bane.getLedigeTiderPaaDag(LocalDate.of(2021,10,11)));

        //Test af opgave 6
        medlem1.createReservation(LocalDate.of(2023,1,6),LocalTime.of(23,0),medlem2,bane);
        System.out.println(medlem1.hasAktivReservation());

        //test af opgave 7
        System.out.println(Service.createReservation(medlem1,medlem2,bane,LocalDate.of(2021,10,9),LocalTime.of(12,0)));
        System.out.println(Service.createReservation(medlem1,medlem2,bane,LocalDate.of(2021,10,10),LocalTime.of(10,0)));

        //Test opgave 9
        Service.createReservation(medlem1,medlem2,bane,LocalDate.of(2021,10,9),LocalTime.of(11,0));
        Service.createReservation(medlem1,medlem2,bane2,LocalDate.of(2021,10,9),LocalTime.of(11,0));
        System.out.println(medlem1.getReservationer());

        //test opgave 10
        Service.writeLedigeTider(LocalDate.of(2021,10,9),"test10");

    }
}
