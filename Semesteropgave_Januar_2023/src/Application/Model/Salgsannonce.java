package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnoncer = 1;
    private int annonceNummer;
    private boolean aktiv;
    private LocalDate udløbsDato;
    private Sælger sælger;
    private ArrayList<Vare> vare;

    public Salgsannonce(Sælger sælger) {
        this.annonceNummer = antalAnnoncer;
        aktiv = true;
        udløbsDato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
        vare = new ArrayList<>();
        antalAnnoncer++;
    }

    public static int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsDato() {
        return udløbsDato;
    }

    public Sælger getSælger() {
        return sælger;
    }

    public ArrayList<Vare> getVare() {
        return vare;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public void setUdløbsDato(LocalDate udløbsDato) {
        this.udløbsDato = udløbsDato;
    }

    public void addVare(Vare vare1) {
        if (!vare.contains(vare1)) {
            vare.add(vare1);
            vare1.setSalgsannonce(this);
        }
    }

    public int samletAnnonceUdbud() {
        int res = 0;
        for (Vare vare1 : vare) {
            res += vare1.getUdbudspris();
        }
        return res;
    }

    public void opdater() {
        if (LocalDate.now().isBefore(udløbsDato)) {
            for (Vare vare1 : vare) {
                if (!vare1.isSolgt()) {
                    aktiv = true;
                    return;
                }
            }
        }
        aktiv = false;
    }

    @Override
    public String toString() {
        return annonceNummer + " " + sælger.getNavn() + " " + udløbsDato.toString();
    }
}
