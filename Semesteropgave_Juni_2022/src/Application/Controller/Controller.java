package Application.Controller;

import Application.Model.Antal;
import Application.Model.Funktion;
import Application.Model.Medarbejder;
import Application.Model.Vagt;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Controller {
    public static Funktion createFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.addFunktion(funktion);
        return funktion;
    }

    public static Medarbejder createMedarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        Medarbejder medarbejder = new Medarbejder(navn, antalTimerPrDag, typiskMødetid);
        Storage.addMedarbejder(medarbejder);
        return medarbejder;
    }

    public static Vagt createVagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        Vagt vagt = new Vagt(navn, tidFra, tidTil);
        Storage.addVagt(vagt);
        return vagt;
    }

    public static void addMedarbejderToVagt(Medarbejder medarbejder, Vagt vagt) throws RuntimeException {
        medarbejder.addVagt(vagt);
    }

    public static void addFunktionToMedarbejder(Medarbejder medarbejder, Funktion funktion) {
        medarbejder.addFunktion(funktion);
    }

    public static void udskrivVagtplan(Vagt vagt, String filNavn) {
        try (PrintWriter printWriter = new PrintWriter("Semesteropgave_Juni_2022/res/" + filNavn)) {
            printWriter.println("---------------------------------------------------");
            printWriter.println(vagt.getTidFra().toString() + " (" + vagt.getNavn() + ")");
            printWriter.println("---------------------------------------------------");
            printWriter.println();
            printWriter.println("Funktioner:");
            for (Antal antal : vagt.getAntal()) {
                printWriter.println("   " + antal.getFunktion() + "(" + antal.getAntal() + ", " + vagt.antalMedarbejdereMedFunktion(antal.getFunktion()) + " medarbejdere)");
            }
            printWriter.println();
            printWriter.print("Medarbejdere: ");
            for (Medarbejder medarbejder : vagt.getMedarbejdere()) {
                printWriter.print(medarbejder.getNavn() + " ");
            }
            printWriter.println();
            printWriter.println();
            printWriter.println("Status: " + vagt.status());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initStorage() {
        Funktion funktion1 = createFunktion("Filetering");
        Funktion funktion2 = createFunktion("Grøntsager");
        Funktion funktion3 = createFunktion("Sovs og tilbehør");
        Funktion funktion4 = createFunktion("Buffetopfyldning");

        Medarbejder medarbejder1 = createMedarbejder("Peter",6,LocalTime.of(8,0));
        Medarbejder medarbejder2 = createMedarbejder("Anne",8,LocalTime.of(8,0));
        Medarbejder medarbejder3 = createMedarbejder("Marie",6,LocalTime.of(10,0));
        Medarbejder medarbejder4 = createMedarbejder("Torben",8,LocalTime.of(7,0));

        Vagt vagt1 = createVagt("Røgede ål til medarbejderne",LocalDateTime.of(2022,6,24,8,0),LocalDateTime.of(2022,6,24,12,30));
        Vagt vagt2 = createVagt("Anden Fest",LocalDateTime.of(2022,6,24,10,0),LocalDateTime.of(2022,6,24,14,30));
        Vagt vagt3 = createVagt("Tredje Fest",LocalDateTime.of(2022,6,24,10,0),LocalDateTime.of(2022,6,24,14,30));


        vagt1.createAntal(2,funktion1);
        vagt1.createAntal(1,funktion2);
        vagt1.createAntal(1,funktion3);
        vagt1.createAntal(1,funktion4);

        addMedarbejderToVagt(medarbejder1,vagt1);
        addMedarbejderToVagt(medarbejder2,vagt1);
        addMedarbejderToVagt(medarbejder3,vagt1);

        addFunktionToMedarbejder(medarbejder1,funktion2);
        addFunktionToMedarbejder(medarbejder1,funktion3);
        addFunktionToMedarbejder(medarbejder1,funktion4);

        addFunktionToMedarbejder(medarbejder2,funktion2);
        addFunktionToMedarbejder(medarbejder2,funktion3);
        addFunktionToMedarbejder(medarbejder2,funktion4);

        addFunktionToMedarbejder(medarbejder3,funktion1);
        addFunktionToMedarbejder(medarbejder3,funktion2);
        addFunktionToMedarbejder(medarbejder3,funktion4);

        addFunktionToMedarbejder(medarbejder4,funktion1);
        addFunktionToMedarbejder(medarbejder4,funktion3);
    }
}
