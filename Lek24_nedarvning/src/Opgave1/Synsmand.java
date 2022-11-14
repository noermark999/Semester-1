package Opgave1;

public class Synsmand extends Mekaniker{
    private int antalSyn;
    private int tillæg;

    public Synsmand(String navn,String adresse, int svendePrøveÅr, int timelønSats, int antalSyn) {
        super(navn, adresse, svendePrøveÅr, timelønSats);
        this.antalSyn = antalSyn;
        this.tillæg = antalSyn * 29;
    }

    public int getAntalSyn() {
        return antalSyn;
    }

    public void setAntalSyn(int antalSyn) {
        this.antalSyn = antalSyn;
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
