package Opgave1;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Peter",5);
        Gift gift = new Gift("Legetøjsbil", 15);
        Gift gift1 = new Gift("Traktor", 20);
        Gift gift2 = new Gift("Taske", 40,person);

        gift.setPerson(person);

        System.out.println(person.getGifts());

        person.addGift(gift1);

        System.out.println(gift1.getPerson());

        System.out.println(person.totalPrice());

        System.out.println(person.getGifts());

    }
}
