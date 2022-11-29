package Lek16.Model;
import java.time.LocalDate;

public class Transaktion {

	private int beløb;
	private LocalDate dato;

	public Transaktion(int beløb) {
		this.beløb = beløb;
		this.dato = LocalDate.now();
	}

	public int getBeløb() {
		return this.beløb;
	}

	public LocalDate getDato() {
		return this.dato;
	}

}
