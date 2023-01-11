import Application.Controller.Controller;
import Application.Model.Funktion;
import Application.Model.Medarbejder;
import Application.Model.Vagt;
import Storage.Storage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Medarbejder medarbejder1 = new Medarbejder("Peter", 7, LocalTime.of(8,0));
        Medarbejder medarbejder2 = new Medarbejder("Lars", 6, LocalTime.of(10,0));
        Medarbejder medarbejder3 = new Medarbejder("Signe", 9, LocalTime.of(7,0));

        Vagt vagt1 = new Vagt("Bryllup", LocalDateTime.of(2022,10,10,9,0),LocalDateTime.of(2022,10,10,21,0));
        Vagt vagt2 = new Vagt("Ål", LocalDateTime.of(2022,10,10,22,10),LocalDateTime.of(2022,10,11,9,9));
        Vagt vagt3 = new Vagt("Nødder", LocalDateTime.of(2022,10,9,22,0),LocalDateTime.of(2022,10,10,10,0));

        vagt1.addMedarbejder(medarbejder1);
        vagt1.addMedarbejder(medarbejder2);
        vagt1.addMedarbejder(medarbejder3);
        vagt2.addMedarbejder(medarbejder1);

        Funktion funktion1 = new Funktion("Lave kager");
        Funktion funktion2 = new Funktion("Lave flødeskum");

        medarbejder1.addFunktion(funktion1);
        medarbejder1.addFunktion(funktion2);
        medarbejder2.addFunktion(funktion1);

        //Test opgave 2
        System.out.println("Opg 2: Skal give en medarbejder: " + vagt1.findMedarbejder(LocalTime.of(8,0),3));
        System.out.println("Opg 2: Skal give null: " + vagt1.findMedarbejder(LocalTime.of(9,0),3));
        System.out.println("Opg 2: Skal give null: " + vagt1.findMedarbejder(LocalTime.of(8,0),10));

        //Test opgave 3
        System.out.println("Opg 3: skal give 12*3 = 36: " + vagt1.beregnTimeforbrug());
        System.out.println("Opg 3: skal give 11: " + vagt2.beregnTimeforbrug());

        //Test opgave 4
        System.out.println("Opg 4: skal give 2: " + vagt1.antalMedarbejdereMedFunktion(funktion1));

        //Test opgave 5
        System.out.println(Arrays.toString(vagt1.skalAdviseresOmMødetid()));

        //Test opgave 6
        vagt1.createAntal(2,funktion1);
        System.out.println(vagt1.status());

        vagt1.createAntal(2,funktion2);
        System.out.println(vagt1.status());

        //Test opgave 7
        medarbejder1.addVagt(vagt3);

        //Test opgave 10
        Controller.initStorage();
        Controller.udskrivVagtplan(Storage.getVagter().get(0), "Test");



    }
}
