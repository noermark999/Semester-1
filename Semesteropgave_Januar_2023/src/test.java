import Application.Controller.Controller;
import Application.Model.Salg;
import Application.Model.Varekategori;
import Storage.Storage;

import java.util.Collections;

public class test {
    public static void main(String[] args) {
        Controller.initStorage();

        //Test Opgave 2
        System.out.println(Storage.getSælgere().get(0).getSalgsannoncer().get(1).samletAnnonceUdbud());

        //Test opgave 3
        System.out.println(Storage.getSælgere().get(0).alleIkkeSolgteVarerIKategori(Varekategori.STUDIEBOG));

        //Test opgave 4
        System.out.println(Storage.getSælgere().get(1).getSalgsannoncer().get(1).isAktiv());
        System.out.println(Storage.getSælgere().get(1).getSalgsannoncer().get(0).isAktiv());

        //Test opgave 8
        Controller.salgTilFil("Test");

        //test opgave 9
        Salg salg = Controller.createSalg("Viktor", 120);
        System.out.println(Controller.sælgerSomHarFortagetKøb().get(0).getNavn());
    }
}
