package Opgave1;

public class Customer implements Comparable<Customer>{
    private String name;
    private String street;
    private int zip;
    private String city;

    public Customer(String name, String street, int zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int compareTo(Customer c1) {

        if(this.zip==c1.zip){
            return this.name.compareTo(c1.name);
        }
        else if(this.zip>c1.zip)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "name=" + name + ", zip=" + zip + "\n";
    }
}
