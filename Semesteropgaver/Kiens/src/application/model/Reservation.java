package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation>{
    private LocalDate dato;
    private LocalTime startTid;
    private LocalTime slutTid;

    private Medlem booker;
    private Medlem makker;
    private Bane bane;

    public Reservation(LocalDate dato, LocalTime startTid, Medlem booker, Medlem makker, Bane bane) {
        this.dato = dato;
        this.startTid = startTid;
        this.booker = booker;
        this.makker = makker;
        this.bane = bane;
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

    //------------------------------------------------------------------------------------------------------------------
    public Bane getBane() {
        return bane;
    }

    public void setBane(Bane bane) {
        if (this.bane != bane) {
            Bane oldBane = this.bane;
            if (oldBane != null) {
                oldBane.removeReservation(this);
            }
            this.bane = bane;
            if (bane != null) {
                bane.addReservation(this);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void setBooker(Medlem medlem) {
        if (this.booker != medlem) {
            Medlem oldMedlem = this.booker;
            if (oldMedlem != null) {
                oldMedlem.removeReservation(this);
            }
            this.booker = medlem;
            if (booker != null) {
                booker.addReservation(this);
            }
        }
    }
    public void setMakker(Medlem medlem) {
        if (this.makker != medlem) {
            Medlem oldMedlem = this.makker;
            if (oldMedlem != null) {
                oldMedlem.removeReservation(this);
            }
            this.makker = medlem;
            if (makker != null) {
                makker.addReservation(this);
            }
        }
    }

    public LocalTime getSlutTid() {

        return slutTid;
    }

    //S8
    @Override
    public int compareTo(Reservation o) {
        if (!this.dato.equals(o.getDato())) {
            return this.dato.compareTo(o.getDato());
        } else if (!this.startTid.equals(o.getStartTid())) {
            return this.startTid.compareTo(o.getStartTid());
        } else {
            return bane.getNummer() - o.bane.getNummer();
        }

    }
}

