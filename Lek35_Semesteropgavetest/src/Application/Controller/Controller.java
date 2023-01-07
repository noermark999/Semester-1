package Application.Controller;

import Application.Model.*;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Controller {

    public static Parkeringshus createParkeringshus(String adresse) {
        Parkeringshus parkeringshus = new Parkeringshus(adresse);
        Storage.addParkeringshus(parkeringshus);
        return parkeringshus;
    }

    public static Parkeringsplads createParkeringsplads(int nummer, Parkeringshus parkeringshus) {
        return parkeringshus.createParkeringsplads(nummer);
    }

    public static Invalideplads createInvalideplads(int nummer, Parkeringshus parkeringshus, double areal) {
        return parkeringshus.createInvalideplads(nummer,areal);
    }

    public static Bil createBil(String regNR, BilMærke bilMærke) {
        Bil bil = new Bil(regNR, bilMærke);
        Storage.addBil(bil);
        return bil;
    }

    public static void addBilToParkeringspladsNr(Bil bil, Parkeringsplads parkeringsplads) {
        parkeringsplads.setBil(bil);
    }

    public static ArrayList<Parkeringshus> sortByAdress(){
        ArrayList<Parkeringshus> p = new ArrayList<>(Storage.getParkeringshuse());
        p.sort(new Comparator<Parkeringshus>() {
            @Override
            public int compare(Parkeringshus o1, Parkeringshus o2) {
                return o1.getAdresse().compareTo(o2.getAdresse());
            }
        });
        return p;
    }

    public static ArrayList<Parkeringshus> sortByLedigepladser() {
        ArrayList<Parkeringshus> p = new ArrayList<>(Storage.getParkeringshuse());

        p.sort(new Comparator<Parkeringshus>() {
            @Override
            public int compare(Parkeringshus o1, Parkeringshus o2) {
                if (o1.antalLedigePladser() < o2.antalLedigePladser()) {
                    return 1;
                }
                if (o1.antalLedigePladser() > o2.antalLedigePladser()) {
                    return -1;
                }
                return 0;
            }
        });
        return p;
    }

    public static void writeOptagnePladser(Parkeringshus hus, String filnavn) {
        try (PrintWriter printWriter = new PrintWriter("Lek35_Test/res/" + filnavn)) {
            for (int i = 0; i < hus.optagnePladser().size(); i++) {
                printWriter.println(hus.optagnePladser().get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createSomeObjects() {
        Bil bil1 = createBil("AB 11 222", BilMærke.AUDI);
        Bil bil2 = createBil("EF 33 444", BilMærke.AUDI);
        Bil bil3 = createBil("BD 55 666", BilMærke.PEUGEOT);
        Bil bil4 = createBil("Bt 52 316", BilMærke.PEUGEOT); //Tilføjet for tests

        Parkeringshus parkeringshus = createParkeringshus("Havnegade 12, 8000 Aarhus");


        for (int i = 1; i <= 100; i++) {
            createParkeringsplads(i,parkeringshus);
        }

        for (int i = 101; i<=110; i++) {
            createInvalideplads(i,parkeringshus,18);
        }

        Storage.getParkeringshuse().get(0).getParkeringspladser().get(0).setBil(bil1);
        Storage.getParkeringshuse().get(0).getParkeringspladser().get(1).setBil(bil2);
        Storage.getParkeringshuse().get(0).getParkeringspladser().get(2).setBil(bil3);
        Storage.getParkeringshuse().get(0).getParkeringspladser().get(105).setBil(bil4);

        Parkeringshus p = createParkeringshus("DOKK1 parkering, 8000 Aarhus");

        for (int i = 1; i <= 100; i++) {
            createParkeringsplads(i,p);
        }
    }
}
