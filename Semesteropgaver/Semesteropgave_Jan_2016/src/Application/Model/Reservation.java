package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation> {
    private LocalDate dato;
    private LocalTime startTid;
    private Medlem booker;
    private Medlem makker;
    private Bane bane;
    private LocalTime slutTid;

    public Reservation(LocalDate dato, LocalTime startTid, Medlem booker, Medlem makker, Bane bane) {
        this.dato = dato;
        this.startTid = startTid;
        this.booker = booker;
        this.makker = makker;
        this.bane = bane;
        bane.addReservation(this);
        makker.addReservation(this);
        slutTid = startTid.plusHours(1);
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public Medlem getBooker() {
        return booker;
    }

    public Medlem getMakker() {
        return makker;
    }

    public Bane getBane() {
        return bane;
    }

    public LocalTime getSlutTid() {
        return slutTid;
    }

    @Override
    public int compareTo(Reservation o) {
        if (!dato.equals(o.getDato())) {
            return dato.compareTo(o.getDato());
        } else if (!startTid.equals(o.getStartTid())) {
            return startTid.compareTo(o.startTid);
        } else {
            return bane.getNummer() - o.getBane().getNummer();
        }
    }

    @Override
    public String toString() {
        return "Dato: " + dato + ", tid: " + startTid + ", banenr: " + bane.getNummer();
    }
}
