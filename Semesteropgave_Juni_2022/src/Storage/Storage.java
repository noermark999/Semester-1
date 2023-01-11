package Storage;

import Application.Model.Funktion;
import Application.Model.Medarbejder;
import Application.Model.Vagt;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Vagt> vagter = new ArrayList<>();
    private static final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private static final ArrayList<Funktion> funktioner = new ArrayList<>();

    public static ArrayList<Vagt> getVagter() {
        return new ArrayList<Vagt>(vagter);
    }

    public static void addVagt(Vagt vagt) {
        vagter.add(vagt);
    }

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<Medarbejder>(medarbejdere);
    }

    public static void addMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
    }

    public static ArrayList<Funktion> getFunktioner() {
        return new ArrayList<Funktion>(funktioner);
    }

    public static void addFunktion(Funktion funktion) {
        funktioner.add(funktion);
    }
}
