package Lek16.Model;

import java.util.ArrayList;

public class Konto {

	private int nr;

	private ArrayList<Transaktion> transaktioner;

	private KontoType kontoType;

	private Tilstand tilstand;

	public Konto(KontoType kontoType) {

		this.kontoType = kontoType;
		this.nr = this.kontoType.getKonti().size() + 1;
		kontoType.addKonto(this);
		this.tilstand = Tilstand.AABEN;
		transaktioner = new ArrayList<Transaktion>();
	}

	public int getNr() {
		return this.nr;
	}

	public Transaktion createTransaktion(int beløb) {
		Transaktion transaktion = null;
		if (tilstand != Tilstand.LUKKET) {
			if (!(tilstand == Tilstand.OVERTRUKKET && beløb < 0)) {
				transaktion = new Transaktion(beløb);
				transaktioner.add(transaktion);
				if (beregnSaldo() < 0) {
					tilstand = Tilstand.OVERTRUKKET;
				} else {
					tilstand = Tilstand.AABEN;
				}
			} else
				throw new RuntimeException("Du forsøger at hæve på en overtrukket konto!");
		} else
			throw new RuntimeException("Kontoen er lukket");

		return transaktion;
	}

	public int beregnSaldo() {
		int saldo = 0;
		for (Transaktion transaktion : transaktioner) {
			saldo += transaktion.getBeløb();
		}
		return saldo;

	}

	public void lukKonto(Konto konto) {
		if (tilstand != Tilstand.OVERTRUKKET){
			System.out.println("De sidste penge på kontoen (" + beregnSaldo() + ") er blevet hævet");
			int saldo = beregnSaldo();
			createTransaktion(-saldo);
			tilstand = Tilstand.LUKKET;
		} else
			throw new RuntimeException("Kontoen er overtrukket og kan ikke lukkes");
	}

	@Override
	public String toString() {
		return "Saldo konto nr. " + getNr() + " er " + beregnSaldo();
	}
}
