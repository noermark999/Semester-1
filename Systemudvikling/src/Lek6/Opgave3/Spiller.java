package Lek6.Opgave3;

public class Spiller {

	private String navn;
	private int alder;
	private String klub;
	private int mål;
	private int vundetKampe;
	private int tabteKampe;
	private int antalKampeSpillet;


	public Spiller(String navn, int alder) {
		this.navn = navn;
		this.alder = alder;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setAlder(int alder) {
		this.alder = alder;
	}

	public int getAlder() {
		return alder;
	}

	public int getTabteKampe() {
		return tabteKampe;
	}

	public int getVundetKampe() {
		return vundetKampe;
	}

	public int getAntalKampeSpillet() {
		return antalKampeSpillet;
	}

	public void tilføjKlub(String klub) {
		this.klub = klub;
	}

	public void tilføjResultat(int mål, boolean vundet) {
		this.mål += mål;
		String kampStatus;
		if (vundet) {
			vundetKampe++;
			spilKamp();
			kampStatus = "vundet";
		} else {
			tabteKampe++;
			spilKamp();
			kampStatus = "tabt";
		}
		System.out.println(navn + " har spillet en kamp og har " + kampStatus + " og scoret " + mål + " mål");
	}

	public void spilKamp() {
		antalKampeSpillet++;
	}

}