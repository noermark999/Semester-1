import Application.Controller.Controller;
import Application.Model.Arrangement;
import Application.Model.Hold;
import Application.Model.Tutor;
import Application.Model.Uddannelse;
import Storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public class test {
    public static void main(String[] args) {
        Arrangement arrangement1 = new Arrangement("Start", LocalDate.of(2022,10,10), LocalTime.of(10,0), LocalTime.of(18,0), 100);
        Arrangement arrangement2 = new Arrangement("Mad", LocalDate.of(2022,10,11), LocalTime.of(18,0), LocalTime.of(19,30), 50);
        Arrangement arrangement3 = new Arrangement("Paintball", LocalDate.of(2022,10,12), LocalTime.of(15,0), LocalTime.of(18,0), 200);

        Tutor tutor1 = new Tutor("Peter", "Peter@mail.com");
        Tutor tutor2 = new Tutor("Lars", "Lars@mail.com");

        Uddannelse uddannelse = new Uddannelse("Datamatiker");

        Hold hold1 = uddannelse.createHold("22t","Søren");

        hold1.addTutor(tutor1);
        hold1.addTutor(tutor2);

        tutor1.addArrangement(arrangement1);

        tutor2.addArrangement(arrangement2);
        tutor2.addArrangement(arrangement3);

        System.out.println("Skal give 350: " + hold1.arrangementsPris());
        System.out.println("Skal give 250: " + tutor2.arrangementsPris());

        //Opgave 4
        Arrangement arrangement4 = new Arrangement("Pizza", LocalDate.of(2022,10,10), LocalTime.of(10,0), LocalTime.of(18,0), 100);
        System.out.println("SKulle gerne være true: " + hold1.harTidsOverlap(arrangement4));

        //Opgave 8
        Controller.initStorage();
        System.out.println(Controller.holdUdenTutorer());

        //Opgave 9
        System.out.println(Storage.getUddannelser().get(0).tutorOversigt());

        //Opgave 10
        Controller.tutorOversigtTilFil("test");


    }
}
