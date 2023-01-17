package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private String baneinfo;
    private int nummer;

    private ArrayList<Reservation> reservationer;

    public Bane(String baneinfo, int nummer) {
        this.baneinfo = baneinfo;
        this.nummer = nummer;
        reservationer = new ArrayList<>();
    }

    public String getBaneinfo() {
        return baneinfo;
    }

    public int getNummer() {
        return nummer;
    }

    //------------------------------------------------------------------------------------------------------------------
    //S9
    public void addReservation(Reservation reservation) {
        int index = 0;
        for (int i = 0; i < reservationer.size(); i++) {
            if (reservationer.get(i).compareTo(reservation) < 0) {
                index++;
            }
        }
        reservationer.add(index, reservation);
    }

    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.setBane(null);
        }

        //------------------------------------------------------------------------------------------------------------------
    }

    //S1
    public boolean isLedig(LocalDate dato, LocalTime tid) {
        boolean res = true;
        for (Reservation reservation : reservationer) {
            if (dato.equals(reservation.getDato()) && tid.equals(reservation.getStartTid())) {
                res = false;
                break;
            }
        }
        return res;
    }

    //S2
    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
        ArrayList<LocalTime> ledigeTiderPaaDag = new ArrayList<>();
        LocalTime tid = LocalTime.of(6, 0); //vi sætter startiden til 06:00 hvilket der står i opgaven
        while (tid.isBefore(LocalTime.of(23, 0))) {
            if (isLedig(dato, tid)) {
                ledigeTiderPaaDag.add(tid);
            }
            tid = tid.plusHours(1); //Vi opdaterer her ved, at den tjekker hver time så loopet kører videre (WHILE LOOPS)
        }
        return ledigeTiderPaaDag;
    }

    @Override
    public String toString() {
        return nummer + "\t" + baneinfo;
    }
}
