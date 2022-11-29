package Lek16.Controller;

import Lek16.Model.Konto;
import Lek16.Model.KontoType;
import Lek16.Storage.Storage;
import Lek16.Model.Konto;
import Lek16.Model.KontoType;
import Lek16.Storage.Storage;

public class Controller {

	public static KontoType createKontoType(String navn, String beskrivelse) {

		KontoType kontoType = new KontoType(navn, beskrivelse);
		Storage.addKontoType(kontoType);
		return kontoType;
	}

	public static Konto createKonto(KontoType kontoType) {
		Konto konto = null;

		konto = new Konto(kontoType);

		return konto;
	}

	public static void foretagTransaktion(Konto konto, int beløb) {
		try {
			konto.createTransaktion(beløb);
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void lukKonto(Konto konto) {
		try {
			konto.lukKonto(konto);
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
