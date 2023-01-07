package Application.Model;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads {
    private double areal;

    public Invalideplads(int nummer, Parkeringshus parkeringshus, double areal) {
        super(nummer, parkeringshus);
        this.areal = areal;
    }

    public double getAreal() {
        return areal;
    }

    @Override
    public int pris(LocalTime afrejse) {
        return 0;
    }
}
