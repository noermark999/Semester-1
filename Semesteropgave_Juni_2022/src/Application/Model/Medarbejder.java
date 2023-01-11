package Application.Model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private ArrayList<Vagt> vagter;
    private ArrayList<Funktion> funktioner;

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
        vagter = new ArrayList<>();
        funktioner = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public ArrayList<Funktion> getFunktioner() {
        return funktioner;
    }

    public void addVagt(Vagt vagt) throws RuntimeException {
        if (!vagter.contains(vagt)) {
            if (vagter.size() == 0) {
                vagter.add(vagt);
                vagt.addMedarbejder(this);
            } else {
                Vagt vagtTemp = null;
                for (Vagt vagt1 : vagter) {
                    if (vagt.getTidFra().isBefore(vagt1.getTidTil()) && vagt.getTidTil().isAfter(vagt1.getTidFra())
                            || (vagt.getTidFra().equals(vagt1.getTidFra()) && vagt.getTidTil().equals(vagt1.getTidTil()))) {
                        vagt.removeMedarbejder(this);
                        throw new RuntimeException("Fejl da " + navn + " allerede har vagt " + vagt1.getNavn() + " indenfor dette tidsrum");
                    } else {
                        vagtTemp = vagt;
                    }
                }
                vagter.add(vagtTemp);
                vagtTemp.addMedarbejder(this);
            }
        }
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.removeMedarbejder(this);
        }
    }


    public void addFunktion(Funktion funktion) {
        if (!funktioner.contains(funktion)) {
            funktioner.add(funktion);
        }
    }

    @Override
    public String toString() {
        return navn + ", Typisk mødetid: " + typiskMødetid.toString();
    }
}
