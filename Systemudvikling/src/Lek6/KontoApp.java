package Lek6;

public class KontoApp {
    public static void main(String[] args) {
        Konto konto = new Konto("Løn Konto",1);
        System.out.println(konto.getStatus());
        System.out.println(konto.getSaldo());
        konto.indsætBeløb(250000);
        konto.indsætBeløb(500);
        System.out.println(konto.getSaldo());
        konto.hævBeløb(100000);
        System.out.println(konto.getSaldo());
        konto.hævBeløb(1000000);
        konto.lukKonto();
        System.out.println(konto.getStatus());
        konto.indsætBeløb(100000);
        System.out.println(konto.getSaldo());
        konto.hævBeløb(50000);
        System.out.println(konto.getSaldo());

    }
}
