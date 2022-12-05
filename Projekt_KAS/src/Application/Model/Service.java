package Application.Model;

public class Service {
    private String navn;

    private int pris;

    public Service(String navn, int pris) {
        this.navn = navn;
        this.pris = pris;
    }

    @Override
    public String toString() {
        return navn;
    }

    public int getPris() {
        return pris;
    }

    public String getNavn() {
        return navn;
    }
}
