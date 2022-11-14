package Opgave4;

public class Arbejdsdreng extends Ansat{
    private int ugeTimer;
    public Arbejdsdreng(String navn,String adresse, int timelønSats) {
        super(navn, adresse, timelønSats);
        ugeTimer = 25;
    }

    public void setUgeTimer(int ugeTimer) {
        this.ugeTimer = ugeTimer;
    }

    public int getUgeTimer() {
        return ugeTimer;
    }

    @Override
    public int beregnLoen() {
        return ugeTimer * getTimelønSats();
    }
}
