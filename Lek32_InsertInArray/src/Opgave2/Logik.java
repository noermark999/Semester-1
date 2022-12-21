package Opgave2;

import java.util.ArrayList;
import java.util.Scanner;

public class Logik {
    private final Scanner scan = new Scanner(System.in);
    private int runder, fejl;
    private final ArrayList<String> bogstaverBrugt = new ArrayList<>();
    private final ArrayList<String> prikketord = new ArrayList<>();
    private String ordet;
    private boolean finished = false;

    public void getWord(boolean danish) {
        ordet = Ord.getOrd(danish);
    }

    public StringBuilder prikketOrd() {
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

    @Override
    public String toString() {
        return prikketOrd().toString();
    }

    public void guess() {
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
                    for (String s : bogstaverBrugt) {
                        if (!ordet.contains(s)) {
                            fejl++;
                        }
                    }
                }
            } else {
                System.out.println("Bogstav er allerede gættet, Prøv igen");
            }
        } else {
            System.out.println("Skriv et bogstav");
        }

    }

    public void find(String sm, String m) {
        for (int i = 0; i < sm.length(); i++) {
            if (match(m, sm, i)){
                prikketord.set(i,m);
            }
        }
    }

    public boolean match(String m, String sm, int i) {
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

    public int getRunder() {
        return runder;
    }

    public int getFejl() {
        return fejl;
    }

    public ArrayList<String> getBogstaverBrugt() {
        return bogstaverBrugt;
    }

    public String getOrdet() {
        return ordet;
    }

    public boolean isFinished() {
        return finished;
    }
}
