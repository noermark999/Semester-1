package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
    private String titel;
    private LocalDate date;
    private LocalTime startTid;
    private LocalTime slutTid;
    private double pris;

    public Arrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
        this.titel = titel;
        this.date = date;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.pris = pris;
    }

    public String getTitel() {
        return titel;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public LocalTime getSlutTid() {
        return slutTid;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return titel + "  " + date.toString() + "  " + startTid + "  " + slutTid;
    }
}
