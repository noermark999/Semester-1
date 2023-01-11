package Application.Model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private int årgang;
    private ArrayList<Deltagelse> deltagelser;

    public Spiller(String navn, int årgang) {
        this.navn = navn;
        this.årgang = årgang;
        deltagelser = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public int getÅrgang() {
        return årgang;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        deltagelser.add(deltagelse);
    }

    public double kampHonorar() {
        double res = 0;
        for (Deltagelse deltagelse : deltagelser) {
            if (!deltagelse.isAfbud()) {
                res += 10;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return navn + ", Honorar: " + kampHonorar();
    }
}
