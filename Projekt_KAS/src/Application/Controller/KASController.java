package Application.Controller;

import Application.Model.*;
import Storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class  KASController {

    /**
     * Creates a new hotel.<br />
     * Requires: pris >= 0.
     */
    public static Hotel createHotel(String navn, int prisEnkelt, int prisDobbelt, String adresse) {
        Hotel hotel = new Hotel(navn, prisEnkelt, prisDobbelt, adresse);
        Storage.addHotel(hotel);
        return hotel;
    }

    /**
     * Deletes the hotel.
     */
    public static void deleteHotel(Hotel hotel) {
        for (Konference konference : getKonferencer()) {
            if (konference.getHotels().contains(hotel)) {
                removeHotelFraKonference(hotel,konference);
            }
            for (Tilmelding tilmelding : konference.getTilmeldings()) {
                tilmelding.removeHotel(hotel);
            }
        }
        Storage.removeHotel(hotel);
    }

    /**
     * Updates the hotel.<br />
     * Requires: wage >= 0.
     */
    public static void updateHotel(Hotel hotel, String navn, int prisEnkelt, int prisDobbelt, String adresse) {
        hotel.setNavn(navn);
        hotel.setPrisEnkelt(prisEnkelt);
        hotel.setPrisDobbelt(prisDobbelt);
        hotel.setAdresse(adresse);
    }

    /**
     * Adds the hotel to the tilmeldning.
     */
    public static void addHotelTilTilmeldning(Hotel hotel, Tilmelding tilmelding) {
        tilmelding.setHotel(hotel);
    }

    /**
     * Removes the hotel from the old tilmeldning if not null.
     */
    public static void removeHotelFraTilmeldning(Hotel hotel, Tilmelding tilmelding) {
        if (hotel != null) {
            tilmelding.removeHotel(hotel);
        }
    }

    public static void addHotelTilKonference(Hotel hotel, Konference konference) {
        konference.addHotel(hotel);
    }

    public static void removeHotelFraKonference(Hotel hotel, Konference konference) {
        if (hotel != null) {
            konference.removeHotel(hotel);
        }
    }

    /**
     * Get all the hoteller.
     */
    public static ArrayList<Hotel> getHotels() {
        return Storage.getHotels();
    }

    // -------------------------------------------------------------------------

    public static Service createService(Hotel hotel, String navn, int pris) {
        Service service = hotel.createService(navn, pris);
        Storage.addService(service);
        return service;
    }

    public static void addServiceTilTilmelding(Hotel hotel, Tilmelding tilmelding,String serviceNavn) {
        for (Service service : hotel.getServices()) {
            if (serviceNavn.equals(service.getNavn())) {
                tilmelding.addService(service);
            }
        }
    }

    // -------------------------------------------------------------------------

    public static Konference createKonference(String navn, String adresse, int pris, LocalDate startDato, LocalDate slutDato) {
        Konference konference = new Konference(navn, adresse, pris, startDato, slutDato);
        Storage.addKonference(konference);
        return konference;
    }

    public static void deleteKonference(Konference konference) {
        if (konference.getTilmeldings().size() > 0) {
            for (Tilmelding tilmelding : konference.getTilmeldings()) {
                deleteTilmeldning(tilmelding);
            }
        }
        Storage.removeKonference(konference);
    }

    public static void updateKonference(Konference konference, String navn,String adresse, int pris, LocalDate startDato, LocalDate slutDato) {
        konference.setAdresse(adresse);
        konference.setNavn(navn);
        konference.setPris(pris);
        konference.setSlutDato(slutDato);
        konference.setStartDato(startDato);
    }

    public static void removeKonferenceFraTilmeldning(Konference konference, Tilmelding tilmelding) {
        if (konference != null) {
            tilmelding.removeKonference(konference);
        }
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    // -------------------------------------------------------------------------

    public static Tilmelding createTilmeldning(Deltager deltager, Konference konference, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato) {
        Tilmelding tilmelding = new Tilmelding(deltager, konference,foredragsholder,ankomstDato,afrejseDato);
        addTilmdningTilKonference(tilmelding,konference);
        addTilmdningTilDeltager(tilmelding,deltager);
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static Tilmelding createTilmeldning(Deltager deltager, Konference konference, boolean foredragsholder, String ledsagerNavn, LocalDate ankomstDato, LocalDate afrejseDato) {
        Tilmelding tilmelding = new Tilmelding(deltager, konference, foredragsholder, ledsagerNavn,ankomstDato,afrejseDato);
        addTilmdningTilKonference(tilmelding,konference);
        addTilmdningTilDeltager(tilmelding,deltager);
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static void deleteTilmeldning(Tilmelding tilmelding) {
        Hotel hotel = tilmelding.getHotel();
        //removeKonferenceFraTilmeldning(tilmelding.getKonference(), tilmelding);
        if (hotel != null) {
            hotel.removeTilmeldning(tilmelding);
        }
        if (tilmelding.getUdflugter().size() > 0) {
            for (Udflugt udflugt1 : tilmelding.getUdflugter()) {
                udflugt1.removeTilmelding(tilmelding);
            }

         }
        Deltager deltager = tilmelding.getDeltager();
        if (deltager != null) {
            deltager.removeTilmeldning(tilmelding);
        }
        Storage.removeTilmelding(tilmelding);
    }

    // -------------------------------------------------------------------------

    public static Udflugt createUdflugt(String navn, LocalDate dato, int pris, boolean frokost) {
        Udflugt udflugt = new Udflugt(navn, dato, pris, frokost);
        Storage.addUdflugt(udflugt);
        return udflugt;
    }

    public static void deleteUdflugt(Udflugt udflugt) {
        if (udflugt.getTilmeldinger().size() > 0) {
            for (Tilmelding tilmelding1 : udflugt.getTilmeldinger()) {
                tilmelding1.removeUdflugt(udflugt);
            }
        }
        for (Konference konference : getKonferencer()) {
            konference.removeUdflugt(udflugt);
        }
        Storage.removeUdflugt(udflugt);
    }

    public static void updateUdflugt(Udflugt udflugt, String navn, int pris, LocalDate dato, boolean frokost) {
        udflugt.setNavn(navn);
        udflugt.setPris(pris);
        udflugt.setDato(dato);
        udflugt.setFrokost(frokost);
    }


    /**
     * Adds the udflugt to the tilmeldning.
     */
    public static void addUdflugtTilTilmeldning(Udflugt udflugt, Tilmelding tilmelding) {
        tilmelding.addUdflugt(udflugt);
    }

    /**
     * Removes the udflugt from the old tilmeldning if not null.
     */
    public static void removeUdflugtFraTilmeldning(Udflugt udflugt, Tilmelding tilmelding) {
        if (udflugt != null) {
            tilmelding.removeUdflugt(udflugt);
        }
    }

    public static void addUdflugtTilKonference(Udflugt udflugt, Konference konference) {
        konference.addUdflugt(udflugt);
    }

    public static void addTilmdningTilKonference(Tilmelding tilmelding, Konference konference) {
        konference.addTilmeldning(tilmelding);
    }

    public static void removeUdflugtFraKonference(Udflugt udflugt, Konference konference) {
        if (udflugt != null) {
            konference.removeUdflugt(udflugt);
        }
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return Storage.getUdflugter();
    }

    public static ArrayList<Udflugt> getUdlfugterKonfDato(Konference konference) {
        LocalDate localDateStart = konference.getStartDato();
        LocalDate localDateSlut = konference.getSlutDato();
        ArrayList<Udflugt> udflugtArrayList =  new ArrayList<>(Storage.getUdflugter());
        ArrayList<Udflugt> sorteretList = new ArrayList<>();
        for (Udflugt udflugt : udflugtArrayList) {
            if (udflugt.getDato().isAfter(localDateStart.minusDays(1)) && udflugt.getDato().isBefore(localDateSlut.plusDays(1))) {
                sorteretList.add(udflugt);
            }
        }
        return sorteretList;
    }

    // -------------------------------------------------------------------------

    public static Deltager createDeltager(String navn, String tlf, String adresse, String byLand) {
        Deltager deltager = new Deltager(navn, tlf, adresse, byLand);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static Deltager createDeltager(String navn, String tlf, String adresse, String byLand, String firma, String firmaTlf) {
        Deltager deltager = new Deltager(navn, tlf, adresse, byLand, firma, firmaTlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void deleteDeltager(Deltager deltager) {
        if (deltager.getTilmeldings().size() > 0) {
            for (Tilmelding tilmelding1 : deltager.getTilmeldings()) {
                Hotel hotel = tilmelding1.getHotel();
                removeKonferenceFraTilmeldning(tilmelding1.getKonference(), tilmelding1);
                if (hotel != null) {
                    hotel.removeTilmeldning(tilmelding1);
                }
            }

        }
        Storage.removeDeltager(deltager);
    }

    public static void updateDeltager(Deltager deltager, String navn, String tlf, String adresse, String byLand) {
        deltager.setAdresse(adresse);
        deltager.setByLand(byLand);
        deltager.setNavn(navn);
        deltager.setTlf(tlf);
    }

    public static void updateDeltager(Deltager deltager, String navn, String tlf, String adresse, String byLand, String firma, String firmatlf) {
        deltager.setAdresse(adresse);
        deltager.setByLand(byLand);
        deltager.setNavn(navn);
        deltager.setTlf(tlf);
        deltager.setFirmaNavn(firma);
        deltager.setFirmaTlf(firmatlf);
    }

    public static ArrayList<Deltager> getDeltager() {
        return Storage.getDeltagere();
    }

    /**
     * Adds the deltager to the tilmeldning.
     */
    public static void addDeltagerTilTilmeldning(Deltager deltager, Tilmelding tilmelding) {
        tilmelding.setDeltager(deltager);
    }

    public static void addTilmdningTilDeltager(Tilmelding tilmelding, Deltager deltager) {
        deltager.addTilmeldning(tilmelding);
    }

    /**
     * Removes the deltager from the old tilmeldning if not null.
     */
    public static void removeDeltagerFraTilmeldning(Deltager deltager, Tilmelding tilmelding) {
        if (deltager != null) {
            tilmelding.removeDeltager(deltager);
        }
    }

    public static void initStorage() {
        LocalDate startdato = LocalDate.of(2022,10,1);
        LocalDate trapholtDato = LocalDate.of(2022,10,2);
        LocalDate slutdato = LocalDate.of(2022,10,3);
        Konference havOGHimmel = createKonference("Hav og Himmel", "Allersgade 27",1500,startdato,slutdato);

        Hotel denHvideSvane = createHotel("Den Hvide Svane",1050,1250,"Langgade 17");

        denHvideSvane.createService("WIFI",50);

        Udflugt egeskov = createUdflugt("Egeskov",startdato,75,false);
        Udflugt trapholt = createUdflugt("Trapholt",trapholtDato,200,true);
        Udflugt byrundturOdense = createUdflugt("Byrundtur i Odensen",slutdato,125,true);

        havOGHimmel.addUdflugt(egeskov);
        havOGHimmel.addUdflugt(trapholt);
        havOGHimmel.addUdflugt(byrundturOdense);

        havOGHimmel.addHotel(denHvideSvane);

        Deltager loneJensen = createDeltager("Lone Jensen", "64931514","Byvej 9","Odense, Danmark");
        Tilmelding loneJensenTilmelding = createTilmeldning(loneJensen,havOGHimmel,true,"Jan Madsen",startdato,slutdato);
        addHotelTilTilmeldning(denHvideSvane,loneJensenTilmelding);
        addServiceTilTilmelding(denHvideSvane,loneJensenTilmelding,"WIFI");
        addUdflugtTilTilmeldning(egeskov,loneJensenTilmelding);
        addUdflugtTilTilmeldning(byrundturOdense,loneJensenTilmelding);

        Deltager finnMadsen = createDeltager("Finn Madsen","91365264","Himmelvej 10","Silkeborg, Danmark");
        Tilmelding finnMadsenTilmelding = createTilmeldning(finnMadsen,havOGHimmel,false,startdato,slutdato);

        Deltager nielsPetersen = createDeltager("Niels Petersen","91398401","Husvej 19","Esbjerg, Danmark");
        Tilmelding nielsPetersenTilmelding = createTilmeldning(nielsPetersen,havOGHimmel,false,startdato,slutdato);
        addHotelTilTilmeldning(denHvideSvane,nielsPetersenTilmelding);

        Deltager peterSommer = createDeltager("Peter Sommer", "64831910","Petersgade 12","Odense, Danmark");
        Tilmelding peterSommerTilmelding = createTilmeldning(peterSommer,havOGHimmel,false,"Mie Sommer",startdato,slutdato);
        addHotelTilTilmeldning(denHvideSvane,peterSommerTilmelding);
        addUdflugtTilTilmeldning(egeskov,peterSommerTilmelding);
        addUdflugtTilTilmeldning(trapholt,peterSommerTilmelding);
        addServiceTilTilmelding(denHvideSvane,peterSommerTilmelding,"WIFI");




    }
}
