package Lek8.Opgave3;

public class Dommer extends Person {

	private String erfaring;
	private int kampeDømt;

	public Dommer(String navn, int alder, String erfaring, int kampeDømt) {
		super(navn, alder);
		this.erfaring = erfaring;
		this.kampeDømt = kampeDømt;
	}

	public String getErfaring() {
		return this.erfaring;
	}

	/**
	 * 
	 * @param erfaring
	 */
	public void setErfaring(String erfaring) {
		this.erfaring = erfaring;
	}

	public int getKampeDømt() {
		return this.kampeDømt;
	}

	/**
	 * 
	 * @param kampeDømt
	 */
	public void setKampeDømt(int kampeDømt) {
		this.kampeDømt = kampeDømt;
	}

	public void dømKamp() {
		kampeDømt++;
	}
	@Override
	public void printPerson() {
		super.printPerson();
		System.out.println("Erfaring: " + erfaring);
		System.out.println("Antal kampe dømt: " + kampeDømt);
	}

}