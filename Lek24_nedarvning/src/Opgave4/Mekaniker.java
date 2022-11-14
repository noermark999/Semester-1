package Opgave4;

public class Mekaniker extends Ansat {
    private int svendePrøveÅr;
    private int timelønSats;
    public Mekaniker(String navn,String adresse, int svendePrøveÅr, int timelønSats) {
        super(navn, adresse, timelønSats);
        this.svendePrøveÅr = svendePrøveÅr;
        this.timelønSats = timelønSats;
    }

    public int getSvendePrøveÅr() {
        return svendePrøveÅr;
    }

    public void setSvendePrøveÅr(int svendePrøveÅr) {
        this.svendePrøveÅr = svendePrøveÅr;
    }

    public int getTimelønSats() {
        return timelønSats;
    }

    public void setTimelønSats(int timelønSats) {
        this.timelønSats = timelønSats;
    }
    @Override
    public int beregnLoen() {
        return 37 * timelønSats;
    }

}
