package Application.Model;

public class Bil {
    private String regNr;

    private BilMærke bilMærke;

    public Bil(String regNr, BilMærke bilMærke) {
        this.regNr = regNr;
        this.bilMærke = bilMærke;
    }

    public String getRegNr() {
        return regNr;
    }

    public BilMærke getBilMærke() {
        return bilMærke;
    }

    public void setBilMærke(BilMærke bilMærke) {
        this.bilMærke = bilMærke;
    }
}
