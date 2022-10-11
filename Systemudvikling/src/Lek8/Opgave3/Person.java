package Lek8.Opgave3;

public class Person {

	private String navn;
	private int alder;
	public Person(String navn, int alder) {
		this.alder = alder;
		this.navn = navn;
	}

	public String getNavn() {
		return this.navn;
	}

	/**
	 * 
	 * @param navn
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getAlder() {
		return this.alder;
	}

	/**
	 * 
	 * @param alder
	 */
	public void setAlder(int alder) {
		this.alder = alder;
	}

	public void printPerson() {
		System.out.println("Navn: " + navn);
		System.out.println("Alder: " + alder);
	}

}