package Opgave2;

import java.util.ArrayList;

public class OrdListe {
    private static ArrayList<String> danske = new ArrayList<>();
    private static ArrayList<String> engelske = new ArrayList<>();

    public static ArrayList<String> getDanske() {
        return danske;
    }

    public static String createDanskOrd(String ord) {
        if (!danske.contains(ord)) {
            danske.add(ord.toLowerCase());
        }
        return ord;
    }

    public void setDanske(ArrayList<String> danske) {
        OrdListe.danske = danske;
    }

    public static ArrayList<String> getEngelske() {
        return engelske;
    }

    public static String createEngelskOrd(String ord) {
        if (!engelske.contains(ord)) {
            engelske.add(ord.toLowerCase());
        }
        return ord;
    }

    public static void setEngelske(ArrayList<String> engelske) {
        OrdListe.engelske = engelske;
    }

}
