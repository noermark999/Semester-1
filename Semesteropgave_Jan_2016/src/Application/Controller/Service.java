package Application.Controller;

import Application.Model.Bane;
import Application.Model.Medlem;
import Application.Model.Reservation;
import Storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Service {

    public static Medlem createMedlem(String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        Storage.addMedlem(medlem);
        return medlem;
    }

    public static Bane createBane(int nummer, String baneInfo) {
        Bane bane = new Bane(nummer,baneInfo);
        Storage.addBane(bane);
        return bane;
    }

    public static Reservation createReservation(Medlem booker, Medlem makker, Bane bane, LocalDate dato, LocalTime startTid) {
        if (bane.isLedig(dato,startTid) && !booker.hasAktivReservation() && !makker.hasAktivReservation()) {
            return booker.createReservation(dato,startTid,makker,bane);
        }
        return null;
    }

    public static void writeLedigeTider(LocalDate dato, String filnavn) {
        try (PrintWriter printWriter = new PrintWriter("Semesteropgave_Jan_2016/res/" + filnavn)) {
            for (Bane bane : Storage.getBaner()) {
                printWriter.println(bane.getLedigeTiderPaaDag(dato));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initStorage() {
        Medlem medlem1 = createMedlem("Lene Mikkelsen", "12345678","lm@msn.com");
        Medlem medlem2 = createMedlem("Finn Jensen", "22331144","fj@msn.com");

        Bane bane = createBane(1,"Nord/syd vendt");
        createBane(2,"Under Egetræet");
        createBane(3,"Med tilskuerpladser");

        medlem1.createReservation(LocalDate.of(2023,1,7),LocalTime.of(11,0),medlem2,bane);

    }
}
