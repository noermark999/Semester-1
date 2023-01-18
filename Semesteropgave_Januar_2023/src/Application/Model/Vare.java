package Application.Model;

public class Vare {
    private Varekategori kategori;
    private String navn;
    private int udbudspris;
    private boolean solgt;
    private Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudspris) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
        solgt = false;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        this.salgsannonce = salgsannonce;
        salgsannonce.addVare(this);
    }

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
        salgsannonce.opdater();
    }

    public String solgtTekst() {
        String tilsalg;
        if (solgt) {
            tilsalg = "Solgt";
        } else {
            tilsalg = "Til salg";
        }
        return tilsalg;
    }

    @Override
    public String toString() {
        return navn + " " + udbudspris + " " + solgtTekst();
    }
}
