import Application.Controller.Controller;
import Application.Model.Kamp;
import Storage.Storage;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main(String[] args) {
        Kamp kamp1 = Controller.createKamp("Herning", LocalDate.of(2021,10,13), LocalTime.of(10,30));
        Kamp kamp2 = Controller.createKamp("Viborg", LocalDate.of(2021,10,12), LocalTime.of(10,30));
        Kamp kamp3 = Controller.createKamp("Harboøre", LocalDate.of(2021,10,10), LocalTime.of(10,30));
        Kamp kamp4 = Controller.createKamp("Herning", LocalDate.of(2021,10,13), LocalTime.of(10,30));
        Kamp kamp5 = Controller.createKamp("Thyborøn", LocalDate.of(2021,10,12), LocalTime.of(10,30));

        ArrayList<Kamp> kampe1 = new ArrayList<>();
        kampe1.add(kamp1);
        kampe1.add(kamp2);
        kampe1.add(kamp3);
        Collections.sort(kampe1);

        ArrayList<Kamp> kampe2 = new ArrayList<>();
        kampe2.add(kamp4);
        kampe2.add(kamp5);
        Collections.sort(kampe2);

        System.out.println(Controller.alleKampe(kampe1,kampe2));

        Controller.createSomeObjects();

        System.out.println(Storage.getKampe().get(5).getDeltagelser());

        Storage.getKampe().get(5).spillerHonorar("test");
    }
}
