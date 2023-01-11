package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneInfo;
    private ArrayList<Reservation> reservationer;

    public Bane(int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
        reservationer = new ArrayList<>();
    }

    public int getNummer() {
        return nummer;
    }

    public String getBaneInfo() {
        return baneInfo;
    }

    public ArrayList<Reservation> getReservationer() {
        return reservationer;
    }

    public void addReservation1(Reservation reservation) {
        reservationer.add(reservation);
    }

    public void addReservation(Reservation reservation) {
        int index = 0;
        for (int i = 0; i < reservationer.size(); i++) {
            if (reservationer.get(i).compareTo(reservation) < 0) {
                index++;
            }
        }
        reservationer.add(index,reservation);
    }

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

    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
        ArrayList<LocalTime> res = new ArrayList<>();
        LocalTime tid = LocalTime.of(6,0);
        while (tid.isBefore(LocalTime.of(23,0))) {
            if (isLedig(dato,tid)) {
                res.add(tid);
            }
            tid = tid.plusHours(1);
        }
        return res;
    }

    @Override
    public String toString() {
        return nummer + " " + baneInfo;
    }
}
