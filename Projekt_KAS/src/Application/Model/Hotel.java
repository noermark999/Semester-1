package Application.Model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private int prisEnkelt;
    private int prisDobbelt;
    private String adresse;
    private ArrayList<Service> services = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public Hotel(String navn, int prisEnkelt, int prisDobbelt, String adresse) {
        this.navn = navn;
        this.prisEnkelt = prisEnkelt;
        this.prisDobbelt = prisDobbelt;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPrisEnkelt() {
        return prisEnkelt;
    }

    public void setPrisEnkelt(int prisEnkelt) {
        this.prisEnkelt = prisEnkelt;
    }

    public int getPrisDobbelt() {
        return prisDobbelt;
    }

    public void setPrisDobbelt(int prisDobbelt) {
        this.prisDobbelt = prisDobbelt;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public void addTilmeldning(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }

    public void removeTilmeldning(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.removeHotel(this);
        }
    }

    public Service createService(String navn, int pris) {
        Service service = new Service(navn, pris);
        services.add(service);
        return service;
    }

    public void removeService(Service service) {
        if (services.contains(service)) {
            services.remove(service);
        }
    }
}
