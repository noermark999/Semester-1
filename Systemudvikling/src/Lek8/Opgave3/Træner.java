package Lek8.Opgave3;

public class Træner extends Person {

	private String erfaring;

	public Træner(String navn, int alder, String erfaring) {
		super(navn, alder);
		this.erfaring = erfaring;
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

	@Override
	public void printPerson() {
		super.printPerson();
		System.out.println("Erfaring: " + erfaring);
	}
}