package Storage;

import Application.Model.Bil;
import Application.Model.Parkeringshus;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
    private static final ArrayList<Bil> biler = new ArrayList<>();

    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return new ArrayList<Parkeringshus>(parkeringshuse);
    }

    public static void addParkeringshus(Parkeringshus parkeringshus) {
        parkeringshuse.add(parkeringshus);
    }

    public static ArrayList<Bil> getBiler() {
        return new ArrayList<Bil>(biler);
    }

    public static void addBil(Bil bil) {
        biler.add(bil);
    }
}
