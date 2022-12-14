package Application.Model;

import java.time.LocalTime;

public class Parkeringsplads {
    private int nummer;
    private LocalTime ankomst;
    private Bil bil;
    private Parkeringshus parkeringshus;
    private final int PRIS = 6;

    public Parkeringsplads(int nummer, Parkeringshus parkeringshus) {
        this.nummer = nummer;
        this.parkeringshus = parkeringshus;
        this.ankomst = null;
    }

    public int getNummer() {
        return nummer;
    }

    public LocalTime getAnkomst() {
        return ankomst;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
        this.ankomst = LocalTime.now();
    }

    private void removeBil() {
        this.bil = null;
    }


    public Parkeringshus getParkeringshus() {
        return parkeringshus;
    }

    public int pris(LocalTime afrejse) {
        if (bil != null) {
            int timeriminutter = (afrejse.getHour() - ankomst.getHour()) * 60;
            int minutter = afrejse.getMinute() - ankomst.getMinute();
            int ialt = (timeriminutter + minutter) / 10;
            return PRIS * ialt;
        } else {
            return 0;
        }
    }

    public void hentBil(LocalTime afgangstidpunkt){
        int pris = pris(afgangstidpunkt);
        removeBil();
        parkeringshus.opdaterSaldo(pris);
    }

    @Override
    public String toString() {
        return nummer + "";
    }
}
