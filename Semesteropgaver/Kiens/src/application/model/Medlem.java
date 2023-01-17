package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobil;
    private String mail;

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
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

    //------------------------------------------------------------------------------------------------------------------
    private ArrayList<Reservation> reservationer;

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    //------------------------------------------------------------------------------------------------------------------
    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public Reservation createReservation (LocalDate dato, LocalTime startTid, Bane bane, Medlem booker, Medlem makker){
        Reservation reservation = new Reservation(dato,startTid,booker,makker,bane);
        reservationer.add(reservation);
        return reservation;
    }

    public void addReservation (Reservation reservation){
        if (!reservationer.contains(reservation)){
            reservationer.add(reservation);
        }
    }

    public void removeReservation (Reservation reservation){
        if (reservationer.contains(reservation)){
            reservationer.remove(reservation);
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    //S6
    public boolean hasAktivReservation() {
        boolean aktivReservation = false;
        LocalTime now = LocalTime.now();
        for (Reservation reservation : reservationer) {
            if (LocalDate.now().isEqual(reservation.getDato()) && now.isAfter(reservation.getStartTid()) && now.isBefore(reservation.getSlutTid())) {
                aktivReservation = true;
            }
        }
        return aktivReservation;
    }
}


