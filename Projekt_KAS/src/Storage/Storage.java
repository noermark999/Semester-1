package Storage;

import Application.Model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Hotel> hotels = new ArrayList<>();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();
    private static final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static final ArrayList<Service> services = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<Hotel>(hotels);
    }

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    // -------------------------------------------------------------------------


    public static ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<Tilmelding>(tilmeldinger);
    }

    public static void addTilmelding(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public static void removeTilmelding(Tilmelding tilmelding) {
        tilmeldinger.remove(tilmelding);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<Konference>(konferencer);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<Udflugt>(udflugter);
    }

    public static void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public static void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Service> getServices() {
        return new ArrayList<Service>(services);
    }

    public static void addService(Service service) {
        services.add(service);
    }

    public static void removeService(Service service) {
        services.remove(service);
    }

}
