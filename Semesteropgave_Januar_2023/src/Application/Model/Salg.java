package Application.Model;

import java.util.ArrayList;

public class Salg implements Comparable<Salg>{
    private String købersNavn;
    private int aftaltSamletPris;
    private ArrayList<Vare> vare;

    public Salg(String købersNavn, int aftaltSamletPris) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        vare = new ArrayList<>();
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public ArrayList<Vare> getVare() {
        return vare;
    }
    public void addVare(Vare vare1) {
        vare.add(vare1);
        vare1.setSolgt(true);
    }

    public int rabat() {
        int sampris = 0;
        for (Vare vare1 : vare) {
            sampris += vare1.getUdbudspris();
        }
        return sampris-aftaltSamletPris;
    }

    @Override
    public int compareTo(Salg o) {
        return this.købersNavn.compareTo(o.getKøbersNavn());
    }
}
