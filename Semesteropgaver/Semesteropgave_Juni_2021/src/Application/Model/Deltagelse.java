package Application.Model;

public class Deltagelse {
    private boolean afbud;
    private String begrundelse;
    private Spiller spiller;
    private Kamp kamp;

    public Deltagelse(Spiller spiller, Kamp kamp) {
        this.spiller = spiller;
        this.kamp = kamp;
        afbud = false;
        spiller.addDeltagelse(this);
    }

    public boolean isAfbud() {
        return afbud;
    }

    public void setAfbud(boolean afbud) {
        this.afbud = afbud;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    public void setBegrundelse(String begrundelse) {
        this.begrundelse = begrundelse;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public Kamp getKamp() {
        return kamp;
    }
}
