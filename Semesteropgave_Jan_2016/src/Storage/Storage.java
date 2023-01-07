package Storage;

import Application.Model.Bane;
import Application.Model.Medlem;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static final ArrayList<Bane> baner = new ArrayList<>();

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<Medlem>(medlemmer);
    }

    public static void addMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<Bane>(baner);
    }

    public static void addBane(Bane bane) {
        baner.add(bane);
    }
}
