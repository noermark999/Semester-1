package Opgave1;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private final ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addGift(Gift gift) {
        if (!gifts.contains(gift)) {
            gifts.add(gift);
            gift.setPerson(this);
        }
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public double totalPrice() {
        double price = 0;
        for (Gift gift : gifts) {
            price += gift.getPrice();
        }
        return price;
    }
}
