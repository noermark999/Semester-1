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
		Controller.foretagTransaktion(k1,0); //Forhindrer exception
		Controller.foretagTransaktion(k1, -200); // giver exception, ikke mere

		Controller.lukKonto(k1);

		Controller.foretagTransaktion(k1,100);

		 Controller.foretagTransaktion(k1, 200);
		 Controller.foretagTransaktion(k1, -300);
		
		 System.out.println(k1);
		
		 Konto k2 = Controller.createKonto(kontotype);
		
		 Controller.foretagTransaktion(k2, 500);
		 Controller.foretagTransaktion(k2, 600);
		 Controller.foretagTransaktion(k2, -1000);
		 System.out.println(k2);
		 Controller.lukKonto(k2);

		 System.out.println(k2);

	}
}
