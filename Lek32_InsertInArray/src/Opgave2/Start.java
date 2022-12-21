package Opgave2;

import java.util.Scanner;

public class Start {

    static Scanner scan = new Scanner(System.in);
    static Logik logik = new Logik();
    public static void startSpil() {
        System.out.println("Velkommen til Ord Gætter");
        System.out.print("Vælg sprog: (d=dansk, e=engelsk): ");
        String sprog = scan.nextLine();
        if (sprog.equalsIgnoreCase("d")) {
            logik.getWord(true);
        } else if (sprog.equalsIgnoreCase("e")) {
            logik.getWord(false);
        }
        System.out.println("Længden af ordet er " + logik.getOrdet().length());
        while (!logik.isFinished()) {
            System.out.printf("%10s", logik + " Brugt " + logik.getBogstaverBrugt() + ". Gæt: ");
            logik.guess();
        }
        System.out.println("Ordet var: " + logik.getOrdet());
        System.out.println("Du gættede ordet med kun " + logik.getRunder() + " gæt og " + logik.getFejl() + " fejl!" );

    }
}
