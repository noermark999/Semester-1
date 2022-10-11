package Lek8.Opgave3;

public class Spiller extends Person {

	private int antalMålScoret;

	public Spiller(String navn, int alder, int antalMålScoret) {
		super(navn, alder);
		this.antalMålScoret = antalMålScoret;
	}

	public int getAntalMålScoret() {
		return this.antalMålScoret;
	}

	/**
	 * 
	 * @param antalMålScoret
	 */
	public void setAntalMålScoret(int antalMålScoret) {
		this.antalMålScoret = antalMålScoret;
	}

	public void spilKamp(int mål) {
		antalMålScoret += mål;
	}

	@Override
	public void printPerson() {
		super.printPerson();
		System.out.println("Antal mål scoret: " + antalMålScoret);
	}

}