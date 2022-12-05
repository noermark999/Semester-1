package Application.Model;

import java.util.ArrayList;

public class Deltager {
    private String navn;

    private String tlf;

    private String adresse;

    private String byLand;

    private String firmaNavn;

    private String firmaTlf;

    private ArrayList<Tilmelding> tilmeldings = new ArrayList<>();


    public Deltager(String navn, String tlf, String adresse, String byLand) {
        this.navn = navn;
        this.tlf = tlf;
        this.adresse = adresse;
        this.byLand = byLand;
    }

    public Deltager(String navn, String tlf, String adresse, String byLand, String firmaNavn, String firmaTlf) {
        this.navn = navn;
        this.tlf = tlf;
        this.adresse = adresse;
        this.byLand = byLand;
        this.firmaNavn = firmaNavn;
        this.firmaTlf = firmaTlf;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getByLand() {
        return byLand;
    }

    public void setByLand(String byLand) {
        this.byLand = byLand;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public String getFirmaTlf() {
        return firmaTlf;
    }

    public void setFirmaTlf(String firmaTlf) {
        this.firmaTlf = firmaTlf;
    }

    public void addTilmeldning(Tilmelding tilmelding){
        if (!tilmeldings.contains(tilmelding)) {
            tilmeldings.add(tilmelding);
        tilmelding.setDeltager(this);
        }
    }

    public void removeTilmeldning(Tilmelding tilmelding) {
        if (tilmeldings.contains(tilmelding)) {
                tilmeldings.remove(tilmelding);
            tilmelding.removeDeltager(this);
        }
    }

    public ArrayList<Tilmelding> getTilmeldings(){
        return tilmeldings;
    }

    public String toString(){
        return navn;
    }

}
