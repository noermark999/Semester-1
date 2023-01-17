package Application.Model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;
    private Hold hold;
    private ArrayList<Arrangement> arrangementer;

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
        arrangementer = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        this.hold = hold;
    }

    public ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }

    public void addArrangement(Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

    public void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }

    public double arrangementsPris() {
        double res = 0;
        for (Arrangement arrangement : arrangementer) {
            res += arrangement.getPris();
        }
        return res;
    }

    public boolean harTidsOverlap(Arrangement arrangement) {
        for (Arrangement arrangement1 : arrangementer) {
            LocalTime start1 = arrangement.getStartTid();
            LocalTime slut1 = arrangement.getSlutTid();
            LocalTime start2 = arrangement1.getStartTid();
            LocalTime slut2 = arrangement1.getSlutTid();
            if (arrangement.getDate().equals(arrangement1.getDate())) {
                //return start1.compareTo(slut2) <= 0 && slut1.compareTo(start2) >= 0;
                return start1.isBefore(slut2) && slut1.isAfter(start2); // <------------------------------- bedste måde -------------------
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return navn + "  " + email;
    }
}
