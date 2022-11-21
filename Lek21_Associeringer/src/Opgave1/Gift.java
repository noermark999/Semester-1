package Opgave1;

public class Gift {
    private final String description;
    private double price;
    private Person person;

    public Gift(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Gift(String description, double price, Person person) {
        this.description = description;
        this.price = price;
        this.person = person;
        person.addGift(this);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPerson(Person person) {
        this.person = person;
        person.addGift(this);
    }

    public Person getPerson() {
        return person;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return this.getDescription();
    }
}
