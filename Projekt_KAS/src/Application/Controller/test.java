package Application.Controller;

import Application.Model.Tilmelding;
import Storage.Storage;

public class test {
    public static void main(String[] args) {
        KASController.initStorage();
        for (Tilmelding tilmelding : Storage.getTilmeldinger()) {
            System.out.println(tilmelding.getDeltager().getNavn() + " pris: " + tilmelding.totalPrice());
        }
    }
}
