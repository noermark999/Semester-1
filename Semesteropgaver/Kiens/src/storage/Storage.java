package storage;

import application.model.Bane;
import application.model.Medlem;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Bane> baner = new ArrayList<>();

    private static ArrayList<Medlem> medlemmer = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Bane> getBaner() {
        return baner;
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }
    public static void addMedlemmer(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public static void addBaner (Bane bane) {
        baner.add(bane);
    }
}
