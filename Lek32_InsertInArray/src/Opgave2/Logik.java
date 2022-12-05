package Opgave2;

import java.util.ArrayList;
import java.util.Scanner;

public class Logik {
    private final Scanner scan = new Scanner(System.in);

    private String ordet;
    private int runder;
    private final ArrayList<String> bogstaverBrugt = new ArrayList<>();
    private boolean finished;
    private final ArrayList<String> prikketord = new ArrayList<>();

    public Logik() {
        initOrdliste();
        startSpil();
    }

    public void startSpil() {
        System.out.println("Velkommen til Ord Gætter");
        System.out.print("Vælg sprog: (d=dansk, e=engelsk): ");
        String sprog = scan.nextLine();
        int size;
        if (sprog.equalsIgnoreCase("d")) {
            size = OrdListe.getDanske().size();
            ordet = OrdListe.getDanske().get((int) ((Math.random() * size -1) + 1));
        } else if (sprog.equalsIgnoreCase("e")){
            size = OrdListe.getEngelske().size();
            ordet = OrdListe.getEngelske().get((int) ((Math.random() * size -1) + 1));
        }
        System.out.println("Længden af ordet er " + ordet.length());
        while (!finished) {
            System.out.printf("%10s", prikketOrd() + " Brugt " + bogstaverBrugt.toString() + ". Gæt: ");
            guess();
        }
        System.out.println("Ordet var: " + ordet);
        System.out.println("Du gættede ordet med kun " + runder + " gæt!");

    }

    private StringBuilder prikketOrd() {
        if (runder == 0) {
            for (int i = 0; i < ordet.length(); i++) {
                prikketord.add("*");
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : prikketord) {
            sb.append(s);
        }

        return sb;
    }

    private void guess() {
        String guess = scan.nextLine();
        guess = guess.toLowerCase();
        if (!bogstaverBrugt.contains(guess)) {
            bogstaverBrugt.add(guess);
            find(ordet,guess);
            runder++;
            if (!prikketord.contains("*")) {
                finished = true;
            }
        } else {
            System.out.println("Bogstav er allerede gættet, Prøv igen");
        }

    }

    public void find(String sm, String m) {
        for (int i = 0; i < sm.length(); i++) {
            if (match(m, sm, i)){
                prikketord.set(i,m);
            }
        }
    }

    private boolean match(String m, String sm, int i) {
        boolean foundDiff = false;
        int j = 0;
        while (!foundDiff && j < m.length()) {
            char k = sm.charAt(i + j);
            if (k != m.charAt(j)){
                foundDiff = true;
            }
            else
                j++;
        }
        return !foundDiff;
    }

    private void initOrdliste() {
        OrdListe.createDanskOrd("Edderkop");
        OrdListe.createDanskOrd("Lejlighed");
        OrdListe.createDanskOrd("Programmet");

        OrdListe.createEngelskOrd("Logic");

    }

}
