package Storage;

import Application.Model.Kamp;
import Application.Model.Spiller;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Kamp> kampe = new ArrayList<>();
    private static final ArrayList<Spiller> spillere = new ArrayList<>();

    public static ArrayList<Kamp> getKampe() {
        return new ArrayList<Kamp>(kampe);
    }

    public static void addKamp(Kamp kamp) {
        kampe.add(kamp);
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<Spiller>(spillere);
    }

    public static void addSpiller(Spiller spiller) {
        spillere.add(spiller);
    }
}
