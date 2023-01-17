package Storage;

import Application.Model.Arrangement;
import Application.Model.Tutor;
import Application.Model.Uddannelse;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static final ArrayList<Tutor> tutors = new ArrayList<>();
    private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public static ArrayList<Uddannelse> getUddannelser() {
        return new ArrayList<Uddannelse>(uddannelser);
    }

    public static void addUddannelse(Uddannelse uddannelse) {
        uddannelser.add(uddannelse);
    }

    public static ArrayList<Tutor> getTutors() {
        return new ArrayList<Tutor>(tutors);
    }

    public static void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<Arrangement>(arrangementer);
    }

    public static void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }
}
