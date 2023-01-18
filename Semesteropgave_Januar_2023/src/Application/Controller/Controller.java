package Application.Controller;

import Application.Model.*;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    public static Sælger createSælger(String navn, int studieKortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studieKortNummer, mobil);
        Storage.addSælger(sælger);
        return sælger;
    }

    public static Vare createVare(Varekategori kategori, String navn, int udbudspris) {
        Vare vare = new Vare(kategori, navn, udbudspris);
        Storage.addVare(vare);
        return vare;
    }

    public static Salg createSalg(String købersNavn, int aftaltSamletPris) {
        Salg salg = new Salg(købersNavn, aftaltSamletPris);
        Storage.addSalg(salg);
        return salg;
    }

    public static void addVareToSalg(Vare vare, Salg salg) {
        salg.addVare(vare);
    }

    public static void addVareToSalgsannonce(Vare vare, Salgsannonce salgsannonce) {
        salgsannonce.addVare(vare);
    }

    public static void salgTilFil(String filNavn) {
        try (PrintWriter printWriter = new PrintWriter("Semesteropgave_Januar_2023/res/" + filNavn)){
            ArrayList<Salg> salgs = Storage.getSalg();
            Collections.sort(salgs);
            for (Salg salg : salgs) {
                printWriter.println(salg.getKøbersNavn());
                for (Vare vare : salg.getVare()) {
                    printWriter.print("\t" + vare.getNavn());
                    printWriter.println("\t" + vare.getUdbudspris());
                }
                printWriter.println("Aftalt pris: " + salg.getAftaltSamletPris() + "\t" + "rabat er: " + salg.rabat());
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Sælger> sælgerSomHarFortagetKøb() {
        ArrayList<Sælger> res = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            for (Salg salg : Storage.getSalg()) {
                if (sælger.getNavn().equals(salg.getKøbersNavn())) {
                    res.add(sælger);
                }
            }
        }
        return res;
    }

    public static ArrayList<Salgsannonce> aktiveAnnoncer() {
        ArrayList<Salgsannonce> res = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            for (Salgsannonce salgsannonce : sælger.getSalgsannoncer()) {
                if (salgsannonce.isAktiv()) {
                    res.add(salgsannonce);
                }
            }
        }
        return res;
    }

    public static void initStorage() {
        Sælger sælger1 = createSælger("Viktor", 23,"45344247");
        Sælger sælger2 = createSælger("Gustav",35,"56124522");

        Vare vare1 = createVare(Varekategori.MOBILTELEFON, "Samsung mobil",1200);
        Vare vare2 = createVare(Varekategori.MOBILTELEFON, "iPhone",2000);
        Vare vare3 = createVare(Varekategori.STUDIEBOG, "Java",400);
        Vare vare4 = createVare(Varekategori.STUDIEBOG, "Android",300);
        Vare vare5 = createVare(Varekategori.STUDIEBOG, "Python",200);
        Vare vare6 = createVare(Varekategori.TØJ, "Regnjakke",100);
        Vare vare7 = createVare(Varekategori.TØJ, "Regnbukser",80);

        Salgsannonce salgsannonce1 = sælger1.createSalgsannonce();
        Salgsannonce salgsannonce2 = sælger1.createSalgsannonce();
        Salgsannonce salgsannonce3 = sælger2.createSalgsannonce();
        Salgsannonce salgsannonce4 = sælger2.createSalgsannonce();

        salgsannonce1.addVare(vare1);
        salgsannonce2.addVare(vare3);
        salgsannonce2.addVare(vare4);
        salgsannonce2.addVare(vare5);
        salgsannonce3.addVare(vare2);
        salgsannonce4.addVare(vare6);
        salgsannonce4.addVare(vare7);

        Salg salg1 = createSalg("Stine",450);
        salg1.addVare(vare4);
        salg1.addVare(vare5);

        Salg salg2 = createSalg("Laura", 120);
        salg2.addVare(vare6);
        salg2.addVare(vare7);

    }
}
