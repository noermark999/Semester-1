package Opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logik {
    private final Scanner scan = new Scanner(System.in);

    private String ordet;
    private int runder, fejl;
    private final ArrayList<String> bogstaverBrugt = new ArrayList<>();
    private boolean finished;
    private final ArrayList<String> prikketord = new ArrayList<>();

    public Logik() {
        initOrdliste();
        try {
            startSpil();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startSpil() throws IOException {
        System.out.println("Velkommen til Ord Gætter");
        System.out.print("Vælg sprog: (d=dansk, e=engelsk): ");
        String sprog = scan.nextLine();
        int size;
        if (sprog.equalsIgnoreCase("d")) {
            size = OrdListe.getDanske().size();
            ordet = OrdListe.getDanske().get((int) ((Math.random() * size -1) + 1));
        } else if (sprog.equalsIgnoreCase("e")){
            URL url = new URL("https://random-word-api.herokuapp.com/word");
            Scanner scanner = new Scanner(url.openStream());
            String randomWord = scanner.nextLine();
            String randomWordTrimmed = randomWord.substring(2,randomWord.length()-2);

            size = randomWordTrimmed.length();
            ordet = randomWordTrimmed;
        }
        System.out.println("Længden af ordet er " + ordet.length());
        while (!finished) {
            System.out.printf("%10s", prikketOrd() + " Brugt " + bogstaverBrugt + ". Gæt: ");
            guess();
        }
        System.out.println("Ordet var: " + ordet);
        System.out.println("Du gættede ordet med kun " + runder + " gæt!");

    }

    private StringBuilder prikketOrd() {
        if (runder == 0 && fejl == 0) {
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
        if (guess.length() != 0) {
            guess = guess.toLowerCase();
            guess = guess.substring(0,1);
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
        } else {
            System.out.println("Skriv et bogstav");
            fejl++;
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
        File file = new File("/Users/jakobnoermark/IdeaProjects/DMU/Lek32_InsertInArray/res/danskeord.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String ord = scanner.nextLine();
                OrdListe.createDanskOrd(ord);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        OrdListe.createEngelskOrd("Logic");

    }

}
