package Application.Model;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;
    private ArrayList<Medarbejder> medarbejdere;
    private ArrayList<Antal> antal;

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
        medarbejdere = new ArrayList<>();
        antal = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return medarbejdere;
    }

    public ArrayList<Antal> getAntal() {
        return antal;
    }

    public Antal createAntal(int antal, Funktion funktion) {
        Antal antal1 = new Antal(antal, funktion);
        this.antal.add(antal1);
        return antal1;
    }

    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejdere.contains(medarbejder)) {
            medarbejdere.add(medarbejder);
            medarbejder.addVagt(this);
        }
    }

    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejdere.contains(medarbejder)) {
            medarbejdere.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }

    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder result = null;
        for (Medarbejder medarbejder : medarbejdere) {
            if (medarbejder.getTypiskMødetid().equals(tidspunkt) && medarbejder.getAntalTimerPrDag() >= antalTimer) {
                result = medarbejder;
            }
        }
        return result;
    }

    public int beregnTimeforbrug() {
        int antalTimer = (int) tidFra.until(tidTil, ChronoUnit.HOURS);
        if (tidFra.getMinute() != tidTil.getMinute()) {
            antalTimer++;
        }
        return antalTimer * medarbejdere.size();
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion) {
        int result = 0;
        for (Medarbejder medarbejder : medarbejdere) {
            if (medarbejder.getFunktioner().contains(funktion)) {
                result++;
            }
        }
        return result;
    }

    public Medarbejder[] skalAdviseresOmMødetid() {
        Medarbejder[] result = new Medarbejder[medarbejdere.size()];
        int i = 0;
        for (Medarbejder medarbejder : medarbejdere) {
            if (medarbejder.getTypiskMødetid().isAfter(tidFra.toLocalTime())) {
                result[i] = medarbejder;
                i++;
            }
        }
        Medarbejder[] result1 = new Medarbejder[i];
        System.arraycopy(result, 0, result1, 0, result1.length);
        return result1;
    }

    public String status() {
        boolean manglerMedarbejdere = false;
        for (Antal antal1 : antal) {
            Funktion funktion = antal1.getFunktion();
            if (antalMedarbejdereMedFunktion(funktion) < antal1.getAntal()) {
                manglerMedarbejdere = true;
            }
        }
        if (manglerMedarbejdere) {
            return "Manglende resourcer";
        } else {
            return "Ressourcer tildelt";
        }
    }

    @Override
    public String toString() {
        return navn ;
    }
}
