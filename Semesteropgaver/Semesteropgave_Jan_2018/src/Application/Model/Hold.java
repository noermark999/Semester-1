package Application.Model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Hold {
    private String betegnelse;
    private String holdleder;
    private Uddannelse uddannelse;
    private ArrayList<Tutor> tutors;

    public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
        this.uddannelse = uddannelse;
        tutors = new ArrayList<>();
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Tutor> getTutors() {
        return tutors;
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
        tutor.setHold(this);
    }

    public double arrangementsPris() {
        double res = 0;
        for (Tutor tutor : tutors) {
            res += tutor.arrangementsPris();
        }
        return res;
    }

    /**
    public boolean harTidsOverlap(Arrangement arrangement) {
        for (Tutor tutor : tutors) {
            for (Arrangement arrangement1 : tutor.getArrangementer()) {
                LocalTime start1 = arrangement.getStartTid();
                LocalTime slut1 = arrangement.getSlutTid();
                LocalTime start2 = arrangement1.getStartTid();
                LocalTime slut2 = arrangement1.getSlutTid();
                if (arrangement.getDate().equals(arrangement1.getDate()) &&
                start1.isBefore(slut2) && slut1.isAfter(start2) &&
                        (arrangement.getStartTid().equals(arrangement1.getStartTid()) && arrangement.getSlutTid().equals(arrangement1.getSlutTid()))) {
                    return true;
                }
            }
        }
        return false;
    }
    **/

    public boolean harTidsOverlap(Arrangement arrangement) {
        for (Tutor tutor : tutors) {
            if (tutor.harTidsOverlap(arrangement)) {
                return true;
            }
        }
        return false;
    }
}
