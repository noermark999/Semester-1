package Application.Controller;

import Application.Model.Arrangement;
import Application.Model.Hold;
import Application.Model.Tutor;
import Application.Model.Uddannelse;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    public static Uddannelse createUddannelse(String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.addUddannelse(uddannelse);
        return uddannelse;
    }

    public static Tutor createTutor(String navn, String email) {
        Tutor tutor = new Tutor(navn, email);
        Storage.addTutor(tutor);
        return tutor;
    }

    public static Arrangement createArrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
        Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void addTutorToHold(Tutor tutor, Hold hold) {
        hold.addTutor(tutor);
    }
    public static void addArrangementToTutor(Arrangement arrangement, Tutor tutor) throws RuntimeException {
        if (!tutor.harTidsOverlap(arrangement)) {
            tutor.addArrangement(arrangement);
        } else {
            throw new RuntimeException("Kunne ikke tilføje arrangement til tutor da der er tidsoverlap");
        }
    }

    public static void removeArrangementFromTutor(Arrangement arrangement, Tutor tutor) {
        tutor.removeArrangement(arrangement);
    }
    public static ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> res = new ArrayList<>();
        for (Uddannelse uddannelse : Storage.getUddannelser()) {
            for (Hold hold : uddannelse.getHold()) {
                if (hold.getTutors().size() == 0) {
                    res.add(hold);
                }
            }
        }
        return res;
    }

    public static void tutorOversigtTilFil(String filnavn) {
        try (PrintWriter printWriter = new PrintWriter("Semesteropgaver/Semesteropgave_Jan_2018/res/" + filnavn)) {
            for (Uddannelse uddannelse : Storage.getUddannelser()) {
                ArrayList<String> oversigt = uddannelse.tutorOversigt();
                for (String s : oversigt) {
                    printWriter.println(s);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initStorage() {
        Uddannelse uddannelse1 = createUddannelse("DMU");
        Uddannelse uddannelse2 = createUddannelse("FINØ");

        Hold hold1 = uddannelse1.createHold("1dmE17S", "Margrethe Dybdahl");
        Hold hold2 = uddannelse1.createHold("1dmE17T", "Kristian Dorland");
        Hold hold3 = uddannelse1.createHold("1dmE17U", "Kell Ørhøj");
        Hold hold4 = uddannelse2.createHold("1fiE17B", "Karen Jensen");

        Tutor tutor1 = createTutor("Anders Hansen","aaa@students.eaaa.dk");
        Tutor tutor2 = createTutor("Peter Jensen","ppp@students.eaaa.dk");
        Tutor tutor3 = createTutor("Niels Madsen","nnn@students.eaaa.dk");
        Tutor tutor4 = createTutor("Lone Andersen","lll@students.eaaa.dk");
        Tutor tutor5 = createTutor("Mads Miller","mmm@students.eaaa.dk");

        Arrangement arrangement1 = createArrangement("Rusfest",LocalDate.of(2017,8,31),LocalTime.of(18,0), LocalTime.of(23,30), 250);
        Arrangement arrangement2 = createArrangement("Fodbold",LocalDate.of(2017,8,30),LocalTime.of(14,0), LocalTime.of(17,30), 100);
        Arrangement arrangement3 = createArrangement("Brætspil",LocalDate.of(2017,8,29),LocalTime.of(12,0), LocalTime.of(16,30), 25);
        Arrangement arrangement4 = createArrangement("Mindeparken",LocalDate.of(2017,8,30),LocalTime.of(18,0), LocalTime.of(22,0), 25);

        addTutorToHold(tutor1,hold1);
        addTutorToHold(tutor4,hold1);
        addTutorToHold(tutor2,hold3);
        addTutorToHold(tutor3,hold3);
        addTutorToHold(tutor5,hold4);

        addArrangementToTutor(arrangement1,tutor1);
        addArrangementToTutor(arrangement1,tutor2);
        addArrangementToTutor(arrangement1,tutor5);
        addArrangementToTutor(arrangement2,tutor3);
        addArrangementToTutor(arrangement3,tutor3);
        addArrangementToTutor(arrangement3,tutor4);
        addArrangementToTutor(arrangement4,tutor1);
        addArrangementToTutor(arrangement4,tutor5);
    }
}
