package Application.Model;

public class Customer {

    public enum SizeCategory {UNKNOWN, MICRO, SMALL, MEDIUM, LARGE}

    String name;
    String street;
    String zip;
    String town;
    SizeCategory category;
    double balance;

    public Customer(String name, String street, String zip, String town, SizeCategory category, double balance) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.town = town;
        this.category = category;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getTown() {
        return town;
    }

    public SizeCategory getCategory() {
        return category;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return getName()+", " + getStreet()+", " + getZip()+" "+getTown() + " Cat: " + getCategory();
    }
}
