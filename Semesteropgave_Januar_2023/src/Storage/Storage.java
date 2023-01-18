package Storage;

import Application.Model.Salg;
import Application.Model.Sælger;
import Application.Model.Vare;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Sælger> sælgere = new ArrayList<>();
    private static final ArrayList<Vare> vare = new ArrayList<>();
    private static final ArrayList<Salg> salg = new ArrayList<>();

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<Sælger>(sælgere);
    }

    public static void addSælger(Sælger sælger) {
        sælgere.add(sælger);
    }

    public static ArrayList<Vare> getVare() {
        return new ArrayList<Vare>(vare);
    }

    public static void addVare(Vare vare1) {
        vare.add(vare1);
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<Salg>(salg);
    }

    public static void addSalg(Salg salg1) {
        salg.add(salg1);
    }
}
