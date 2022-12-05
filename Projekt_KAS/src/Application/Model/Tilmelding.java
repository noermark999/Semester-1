package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private Deltager deltager;
    private Hotel hotel;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private Konference konference;
    private boolean foredragsholder;
    private String ledsagerNavn;
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;

    private ArrayList<Service> services = new ArrayList<>();

    public Tilmelding(Deltager deltager, Konference konference, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato) {
        this.deltager = deltager;
        this.konference = konference;
        this.foredragsholder = foredragsholder;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
    }

    public Tilmelding(Deltager deltager, Konference konference, boolean foredragsholder, String ledsagerNavn, LocalDate ankomstDato, LocalDate afrejseDato) {
        this.deltager = deltager;
        this.konference = konference;
        this.foredragsholder = foredragsholder;
        this.ledsagerNavn = ledsagerNavn;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
    }

    @Override
    public String toString() {
        if (ledsagerNavn != null) {
            return deltager.getNavn() + " og " + ledsagerNavn + " (" + totalPrice() + " kr.)";
        }
        return deltager.getNavn() + " (" + totalPrice() + " kr.)";
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Konference getKonference() {
        return konference;
    }

    public boolean erForedragsholder() {
        return foredragsholder;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public String getLedsagerNavn() {
        return ledsagerNavn;
    }

    public void setLedsagerNavn(String ledsagerNavn) {
        this.ledsagerNavn = ledsagerNavn;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
        deltager.addTilmeldning(this);
    }

    public void removeDeltager(Deltager deltager) {
        this.deltager = null;
        deltager.removeTilmeldning(this);
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
        hotel.addTilmeldning(this);
    }

    public void removeHotel(Hotel hotel) {
        this.hotel = null;
        hotel.removeTilmeldning(this);
    }

    public void removeKonference(Konference konference) {
        this.konference = null;
        konference.removeTilmeldning(this);
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    public void setUdflugter(ArrayList<Udflugt> udflugter) {
        this.udflugter = udflugter;
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addTilmelding(this);
        }
    }
    public void removeUdflugt(Udflugt udflugt){
        if(udflugter.contains(udflugt)){
            udflugter.remove(udflugt);
            udflugt.removeTilmelding(this);
        }
    }

    public void addService(Service service) {
        if(!services.contains(service)){
            services.add(service);
        }
    }

    public void removeService(Service service){
        if(services.contains(service)){
            services.remove(service);
        }
    }

    public double totalPrice() {
        double sum = 0;
        int dage = afrejseDato.compareTo(ankomstDato);
        if (!foredragsholder) {
            if (konference != null) {
                sum += (dage + 1) * konference.getPris();
            }
        }
        for (Udflugt udflugt : udflugter) {
            sum += udflugt.getPris();
        }
        if (hotel != null) {
            if (ledsagerNavn != null) {
                sum += (dage) * hotel.getPrisDobbelt();
            } else {
                sum += (dage) * hotel.getPrisEnkelt();
            }
            for (Service service : services) {
                sum += service.getPris()*dage;
            }
        }
        return sum;
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }
}
