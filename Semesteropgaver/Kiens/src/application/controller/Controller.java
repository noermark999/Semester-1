package application.controller;


import application.model.Bane;
import application.model.Medlem;
import application.model.Reservation;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Bane createBane(String baneinfo, int nummer) {
        Bane bane = new Bane(baneinfo, nummer);
        Storage.addBaner(bane);
        return bane;
    }

    public static Medlem createMedlem(String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        Storage.addMedlemmer(medlem);
        return medlem;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void initStorage() {

        Medlem leneMikkelsen = createMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Medlem finnJensen = createMedlem("Finn Jensen", "22331144", "fj@msn.com");

        Bane bane1 = createBane("Nord/syd vendt", 1);
        Bane bane2 = createBane("Under Egetræet", 2);
        Bane bane3 = createBane("Med tilskuerpladser", 3);
    }

    //------------------------------------------------------------------------------------------------------------------
    //S7
    public static Reservation createReservation(LocalDate dato, LocalTime startTid, Medlem booker, Medlem makker, Bane bane) {
        if (bane.isLedig(dato, startTid) && !booker.hasAktivReservation() && !makker.hasAktivReservation()) {
            booker.createReservation(dato, startTid, bane, booker, makker);
        }
        return null;
    }

    public static void writeLedigeTider(LocalDate dato, String filnavn) {
        try (PrintWriter printWriter = new PrintWriter("PRO januar 2016/res/" + filnavn)) {
            for (Bane bane: Storage.getBaner()) {
                    printWriter.println(bane.getLedigeTiderPaaDag(dato));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }


}
