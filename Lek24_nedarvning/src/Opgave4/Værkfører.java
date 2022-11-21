package Opgave4;

public class Værkfører extends Ansat {
    private int udnævnelsesÅr;
    private int tillæg;
    private final int svendePrøveÅr;
    public Værkfører(String navn,String adresse, int svendePrøveÅr, int timelønSats, int udnævnelsesÅr, int tillæg) {
        super(navn, adresse, timelønSats);
        this.svendePrøveÅr = svendePrøveÅr;
        this.udnævnelsesÅr = udnævnelsesÅr;
        this.tillæg = tillæg;
    }

    public int getUdnævnelsesÅr() {
        return udnævnelsesÅr;
    }

    public void setUdnævnelsesÅr(int udnævnelsesÅr) {
        this.udnævnelsesÅr = udnævnelsesÅr;
    }

    public int getTillæg() {
        return tillæg;
    }

    public void setTillæg(int tillæg) {
        this.tillæg = tillæg;
    }

    @Override
    public int beregnLoen() {
        return 37 * getTimelønSats() + tillæg;
    }
}
