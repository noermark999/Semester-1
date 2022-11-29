package Lek16.Model;

import java.util.ArrayList;

public class KontoType {

	private String navn;

	private String beskrivelse;

	private ArrayList<Konto> konti;

	public KontoType(String navn, String beskrivelse) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		konti = new ArrayList<Konto>();
	}

	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return this.beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public ArrayList<Konto> getKonti() {
		return this.konti;
	}

	public void addKonto(Konto konto) {
		konti.add(konto);
	}

}
