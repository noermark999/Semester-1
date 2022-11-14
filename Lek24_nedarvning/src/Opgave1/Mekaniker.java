package Opgave1;

public class Mekaniker extends Person{
    private int svendePrøveÅr;
    private int timelønSats;

    public Mekaniker(String navn,String adresse, int svendePrøveÅr, int timelønSats) {
        super(navn,adresse);
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

    public int beregnLoen() {
        return 37 * timelønSats;
    }

}
