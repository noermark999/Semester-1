package studerende;

/**
 * Klasse der beskriver en studerende
 *
 * @author mad
 *
 */
public class Studerende {
	/*
	 * Attributter der beskriver den studerendes tilstand
	 */
	private String navn;
	private boolean aktiv;
	private int alder;

	/*
	 * Constructor, når den studerende oprettes, skal den have et navn. Ved
	 * oprettelse er den studerende ikke aktiv
	 */
	public Studerende(String navn, int alder) {
		this.navn = navn;
		this.alder = alder;
		this.aktiv = false;
	}

	/*
	 * Constructor, når den studerende oprettes, skal den have et navn. Ved
	 * oprettelse er den studerende ikke aktiv
	 */
	public Studerende(String navn, int alder, boolean aktiv) {
		this.navn = navn;
		this.alder = alder;
		this.aktiv = aktiv;
	}

	/*
	 * Man kan få oplyst den studerendes alder, ved at kalde metoden getAlder
	 */
	public int getAlder() {
		return alder;
	}

	/*
	 * Den studerendes alder kan ændres ved kald af setAlder metoden
	 */
	public void setAlder(int alder) {
		this.alder = alder;
	}

	/*
	 * Den studerendes navn kan ændres ved kald af setNavn metoden
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/*
	 * Man kan få oplyst den studerendes navn, ved at kalde metoden getNavn
	 */
	public String getNavn() {
		return navn;
	}

	/*
	 * Den studerendes kan få ændret aktivitets status ved at kalde metoden
	 * setStatus
	 */
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	/*
	 * Man kan få oplyst den studerendes aktivitet, ved at kalde metoden isAktiv
	 */
	public boolean isAktiv() {
		return aktiv;
	}

	public void fødselsdag() {
		alder++;
	}

	public String arbejde() {
		String result = "";
		if (alder < 16) {
			result = "Gå i skole - du er jo kun et barn";
		} else if (alder < 20) {
			result = "Nyd din gymnasietid - og lær at studer";
		} else if (alder == 20) {
			result = "Tag et sabbatår";
		} else if (alder <= 23) {
			result = "Kom igang med datamatikerudannelsen";
		} else if (alder < 30) {
			result = "Tag nu dit studie seriøst";
		} else {
			result = "Arbejd hårdt";
		}
		return result;
	}
	
	public String arbejde2() {
		String result ="Arbejd hårdt";
		if (alder < 16) {
			result = "Gå i skole - du er jo kun et barn";
		} 
		if (alder >=16 && alder < 20) {
			result = "Nyd din gymnasietid - og lær at studer";
		} 
		if (alder == 20) {
			result = "Tag et sabbatår";
		}
		if (alder > 20 && alder <= 23) {
			result = "Kom igang med datamatikerudannelsen";
		} 
		if (alder >23 && alder < 30) {
			result = "Tag nu dit studie seriøst";
		}
		return result;
	}
	
	public String studieAktiv() {
		String result = "";
		if (aktiv) {
			result = "Flittig ";
			if (alder > 68) {
				result = result + "pensionist";
			} 
			else if(alder < 18) {
				result = result + "elev";
			}
		}
		else {
			result = "Ikke aktiv";
		}
		return result;
	}

}
