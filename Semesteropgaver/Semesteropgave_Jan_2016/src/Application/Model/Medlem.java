package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobil;
    private String mail;
    private ArrayList<Reservation> reservationer;

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
        reservationer = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<Reservation> getReservationer() {
        return reservationer;
    }

    public Reservation createReservation(LocalDate dato, LocalTime startTid, Medlem makker, Bane bane) {
        Reservation reservation = new Reservation(dato,startTid,this,makker,bane);
        addReservation(reservation);
        return reservation;
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

    public boolean hasAktivReservation() {
        boolean res = false;
        LocalTime now = LocalTime.now();
        for (Reservation reservation : reservationer) {
            if (LocalDate.now().isEqual(reservation.getDato()) && now.isAfter(reservation.getStartTid()) && now.isBefore(reservation.getSlutTid())) {
                res = true;
            }
        }
        return res;
    }
}
