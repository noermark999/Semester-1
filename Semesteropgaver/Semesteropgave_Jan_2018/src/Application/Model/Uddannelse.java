package Application.Model;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Uddannelse {
    private String navn;
    private ArrayList<Hold> hold;

    public Uddannelse(String navn) {
        this.navn = navn;
        hold = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Hold> getHold() {
        return hold;
    }

    public Hold createHold(String betegnelse, String holdleder) {
        Hold hold1 = new Hold(betegnelse, holdleder, this);
        hold.add(hold1);
        return hold1;
    }

    public ArrayList<String> tutorOversigt() {
        ArrayList<String> res = new ArrayList<>();
        StringJoiner stringJoiner = new StringJoiner("\t");
        for (Hold hold1 : hold) {
            for (Tutor tutor : hold1.getTutors()) {
                stringJoiner.add(tutor.getNavn());
                stringJoiner.add(navn);
                stringJoiner.add(hold1.getBetegnelse());
                stringJoiner.add(tutor.getEmail());
                stringJoiner.add(hold1.getHoldleder());
                res.add(stringJoiner.toString());
                stringJoiner = new StringJoiner("\t");
            }
        }
        return res;
    }
}
