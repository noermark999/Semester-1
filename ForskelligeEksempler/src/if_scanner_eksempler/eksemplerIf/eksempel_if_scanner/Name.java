package eksempel_if_scanner;

public class Name {
	private String firstName;
	private String middleName;
	private String lastName;

	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInit() {
		return "" + firstName.charAt(0) + middleName.charAt(0)
				+ lastName.charAt(0);
	}

	public String getUserName() {
		String tekst1 = firstName.substring(0, 2).toUpperCase();
		String tekst2 = middleName.length() + "";
		String tekst3 = lastName.substring(lastName.length() - 2);
		return tekst1 + tekst2 + tekst3;

	}
}
