package Lek16.Model;

import Lek16.Controller.Controller;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Controller
				.createKontoType(
						"Ungdomskonto",
						"En kontotype til unge under 25, som for at beskytte du unge ikke tillader at der hæves på en konto med saldo under 0");

		Konto k1 = Controller.createKonto(kontotype);

		Controller.foretagTransaktion(k1, 100);
		Controller.foretagTransaktion(k1, 200);
		Controller.foretagTransaktion(k1, -400);
		Controller.foretagTransaktion(k1,800); //Forhindrer exception
		Controller.foretagTransaktion(k1, -200); // giver exception, ikke mere

		// Service.foretagTransaktion(k1, 200);
		// Service.foretagTransaktion(k1, -300);
		//
		// System.out.println(k1);
		//
		// Konto k2 = Service.createKonto(kontotype);
		//
		// Service.foretagTransaktion(k2, 500);
		// Service.foretagTransaktion(k2, 600);
		// Service.foretagTransaktion(k2, -1000);
		// System.out.println(k2);

	}
}
