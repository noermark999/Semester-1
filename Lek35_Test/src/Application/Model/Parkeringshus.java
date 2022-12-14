package Application.Model;

import java.util.ArrayList;

public class Parkeringshus {
    private String adresse;

    private ArrayList<Parkeringsplads> parkeringspladser;

    private int saldo;

    public Parkeringshus(String adresse) {
        this.adresse = adresse;
        parkeringspladser = new ArrayList<>();
    }

    public String getAdresse() {
        return adresse;
    }

    public int getSaldo() {
        return saldo;
    }

    public void opdaterSaldo(int saldo) {
        this.saldo += saldo;
    }

    public ArrayList<Parkeringsplads> getParkeringspladser() {
        return parkeringspladser;
    }

    public Parkeringsplads createParkeringsplads(int nummer) {
        Parkeringsplads parkeringsplads = new Parkeringsplads(nummer, this);
        parkeringspladser.add(parkeringsplads);
        return parkeringsplads;
    }

    public Invalideplads createInvalideplads(int nummer, double areal) {
        Invalideplads invalideplads = new Invalideplads(nummer, this, areal);
        parkeringspladser.add(invalideplads);
        return invalideplads;
    }

    public int antalLedigePladser() {
        int result = 0;
        for (Parkeringsplads parkeringsplads : parkeringspladser) {
            if (parkeringsplads.getBil() == null) {
                result++;
            }
        }
        return result;
    }

    public int findPladsMedBil(String regNummer) {
        Parkeringsplads parkeringsplads = null;
        int i = 0;
        while (parkeringsplads == null && i < parkeringspladser.size()) {
            Parkeringsplads k = parkeringspladser.get(i);
            if (k.getBil() != null) {
                if (k.getBil().getRegNr().equals(regNummer))
                    parkeringsplads = k;
                else
                    i++;
            } else {
                return -1;
            }
        }
        if (parkeringsplads != null) {
            return parkeringsplads.getNummer();
        } else {
            return -1;
        }
    }

    public int findAntalBiler(BilMærke bilMærke) {
        int result = 0;
        for (Parkeringsplads p : parkeringspladser) {
            if (p.getBil() != null) {
                if (p.getBil().getBilMærke().equals(bilMærke)) {
                    result++;
                }
            }
        }
        return result;
    }

    public ArrayList<String> optagnePladser() {
        ArrayList<String> strings = new ArrayList<>();
        for (Parkeringsplads p : parkeringspladser) {
            if (p.getBil() != null) {
                strings.add("Nr: " + p.getNummer() + ", regNr: " + p.getBil().getRegNr() + ", bilmærke: " + p.getBil().getBilMærke());
            }
        }
        return strings;
    }

    @Override
    public String toString() {
        return adresse;
    }
}
