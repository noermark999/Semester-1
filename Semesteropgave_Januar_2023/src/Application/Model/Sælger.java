package Application.Model;

import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studieKortNummer;
    private String mobil;
    private ArrayList<Salgsannonce> salgsannoncer;

    public Sælger(String navn, int studieKortNummer, String mobil) {
        this.navn = navn;
        this.studieKortNummer = studieKortNummer;
        this.mobil = mobil;
        salgsannoncer = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public int getStudieKortNummer() {
        return studieKortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return salgsannoncer;
    }

    public Salgsannonce createSalgsannonce() {
        Salgsannonce salgsannonce = new Salgsannonce(this);
        salgsannoncer.add(salgsannonce);
        return salgsannonce;
    }

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(Varekategori kategori) {
        ArrayList<Vare> res = new ArrayList<>();
        for (Salgsannonce salgsannonce : salgsannoncer) {
            if (salgsannonce.isAktiv()) {
                for (Vare vare : salgsannonce.getVare()) {
                    if (vare.getKategori().equals(kategori) && !vare.isSolgt()) {
                        res.add(vare);
                    }
                }
            }
        }
        return res;
    }
}
