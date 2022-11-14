package Opgave1;

public class Værkfører extends Mekaniker{
    private int udnævnelsesÅr;
    private int tillæg;
    public Værkfører(String navn,String adresse, int svendePrøveÅr, int timelønSats, int udnævnelsesÅr, int tillæg) {
        super(navn, adresse, svendePrøveÅr, timelønSats);
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
        return super.beregnLoen() + tillæg;
    }
}
