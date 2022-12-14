package Application.Controller;

import Application.Model.Bil;
import Application.Model.BilMærke;
import Storage.Storage;

import java.time.LocalTime;

public class test {
    public static void main(String[] args) {
        Controller.createSomeObjects();

        //test af opgave2
        System.out.println("Antal ledige pladser " + Storage.getParkeringshuse().get(0).antalLedigePladser());

        //test af opgave3
        System.out.println("Plads på bil: " + Storage.getParkeringshuse().get(0).findPladsMedBil("AB 11 222"));
        System.out.println("Plads på bil: " + Storage.getParkeringshuse().get(0).findPladsMedBil("An 11 222"));

        //Test af Opgave4
        LocalTime localTime = LocalTime.of(12,50);
        System.out.println("Pris " + Storage.getParkeringshuse().get(0).getParkeringspladser().get(0).pris(localTime));
        System.out.println("Pris " + Storage.getParkeringshuse().get(0).getParkeringspladser().get(105).pris(localTime));

        //Test af opgave 8 (Blev nødt til at teste opgave 8 før opgave 5 da jeg fjerner to biler der)
        BilMærke bilMærke = BilMærke.AUDI;
        System.out.println("Biler med bilmærke " + bilMærke + ": " + Storage.getParkeringshuse().get(0).findAntalBiler(bilMærke));

        //Test af opgave10 (Igen før opgave 5)
        Controller.writeOptagnePladser(Storage.getParkeringshuse().get(0), "testfør5");

        //Test af opgave 5
        LocalTime localTime1 = LocalTime.of(12,29);
        Storage.getParkeringshuse().get(0).getParkeringspladser().get(0).hentBil(localTime1);
        Storage.getParkeringshuse().get(0).getParkeringspladser().get(1).hentBil(localTime1);
        System.out.println("Saldo for Parkeringshus: " + Storage.getParkeringshuse().get(0).getSaldo());


        //Test af opgave10
        Bil bil = Controller.createBil("GL 54 634", BilMærke.BMW);
        Controller.addBilToParkeringspladsNr(bil, Storage.getParkeringshuse().get(0).getParkeringspladser().get(3));
        Controller.writeOptagnePladser(Storage.getParkeringshuse().get(0), "test");


    }
}
