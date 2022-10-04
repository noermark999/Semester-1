package Lek6;

public class Konto {
    private int nr;
    private int saldo;
    private String kontoType;
    private String status;

    public Konto(String kontoType, int nr) {
        this.nr = nr;
        this.kontoType = kontoType;
        saldo = 0;
        status = "åben";
    }

    public int getNr() {
        return nr;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setKontoType(String kontoType) {
        this.kontoType = kontoType;
    }

    public String getKontoType() {
        return kontoType;
    }

    public String getStatus() {
        return status;
    }

    public void indsætBeløb(int beløb) {
        if (status.equalsIgnoreCase("åben")) {
            saldo += beløb;
        } else {
            System.out.println("Kan ikke indsætte beløb konto er lukket");
        }
    }

    public void hævBeløb(int beløb) {
        if (status.equalsIgnoreCase("åben")) {
            if (saldo<beløb) {
                System.out.println("Ikke nok på konto");
                System.out.println("Du prøvede at hæve: " + beløb + " men der er kun " + saldo + " på konto");
            } else {
                saldo -= beløb;
            }
        } else {
            System.out.println("Kan ikke hæve beløb konto er lukket");
        }
    }

    public void lukKonto() {
        status = "lukket";
    }
}
