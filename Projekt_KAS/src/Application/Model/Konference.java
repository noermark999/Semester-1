package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Konference {
    private String navn;

    private String adresse;

    private int pris;

    private LocalDate startDato;

    private LocalDate slutDato;

    private ArrayList<Tilmelding> tilmeldings = new ArrayList<>();

    private ArrayList<Hotel> hoteller = new ArrayList<>();

    private ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Konference(String navn, String adresse, int pris, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.adresse = adresse;
        this.pris = pris;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public void addTilmeldning(Tilmelding tilmelding){
        tilmeldings.add(tilmelding);
    }

    public ArrayList<Tilmelding> getTilmeldings(){
        return tilmeldings;
    }

    public void createTilmeldning(Deltager deltager, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato){
        Tilmelding tilmelding1 = new Tilmelding(deltager, this,foredragsholder,ankomstDato,afrejseDato);
        tilmeldings.add(tilmelding1);
    }

    public void createTilmeldning(Deltager deltager, boolean foredragsholder, String ledsagerNavn, LocalDate ankomstDato, LocalDate afrejseDato){
        Tilmelding tilmelding1 = new Tilmelding(deltager, this, foredragsholder, ledsagerNavn,ankomstDato,afrejseDato);
        tilmeldings.add(tilmelding1);
    }

    public void removeTilmeldning(Tilmelding tilmelding){
        if (tilmeldings.contains(tilmelding)) {
           tilmeldings.remove(tilmelding);
        }
    }

    public void addHotel(Hotel hotel){
        if(!hoteller.contains(hotel)){
            hoteller.add(hotel);
        }
    }

    public void removeHotel(Hotel hotel){
        if(hoteller.contains(hotel)){
            hoteller.remove(hotel);
        }
    }

    public void addUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)){
            udflugter.add(udflugt);
        }
    }

    public void removeUdflugt(Udflugt udflugt){
        if(udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }

    public ArrayList<Hotel> getHotels(){
        return hoteller;
    }

    public  ArrayList<Udflugt> getUdflugter(){
        return  udflugter;
    }

    public String toString(){
        return navn;
    }
}
