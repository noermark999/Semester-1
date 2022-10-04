package Lek6.Opgave3;


public class SpillerApp {
    public static void main(String[] args) {
        Spiller spiller1 = new Spiller("Peter", 15);
        spiller1.tilføjResultat(3, true);
        System.out.println(spiller1.getAntalKampeSpillet());
        System.out.println(spiller1.getVundetKampe());
    }
}
