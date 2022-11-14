package Opgave4;

public abstract class Ansat extends Person{
    private int timelønSats;
    public Ansat(String navn,String adresse, int timelønSats) {
        super(navn,adresse);
        this.timelønSats = timelønSats;
    }

    public int getTimelønSats() {
        return timelønSats;
    }

    public void setTimelønSats(int timelønSats) {
        this.timelønSats = timelønSats;
    }
    public abstract int beregnLoen();
}
