package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Udflugt {

    private String navn;
    private LocalDate dato;
    private int pris;
    private boolean frokost;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public Udflugt(String navn, LocalDate dato, int pris, boolean frokost) {
        this.navn = navn;
        this.dato = dato;
        this.pris = pris;
        this.frokost = frokost;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.addUdflugt(this);
        }
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.removeUdflugt(this);
        }
    }

        public String getNavn () {
            return navn;
        }

        public void setNavn (String navn){
            this.navn = navn;
        }

        public LocalDate getDato () {
            return dato;
        }

        public void setDato (LocalDate dato){
            this.dato = dato;
        }

        public int getPris () {
            return pris;
        }

        public void setPris (int pris){
            this.pris = pris;
        }

        public boolean getFrokost () {
            return frokost;
        }

        public void setFrokost ( boolean frokost) {
            this.frokost = frokost;
        }

        public String toString(){
        return navn;
        }
    }
