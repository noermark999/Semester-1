package Lek8.Opgave3;

public class Testprogram {
    public static void main(String[] args) {
        Træner træner = new Træner("Peter",41,"Ingen");

        Spiller spiller = new Spiller("Søren",14,12);

        Dommer dommer = new Dommer("Christian",55,"Ingen, frivillig", 10);

        træner.printPerson();

        System.out.println();

        spiller.printPerson();

        System.out.println();

        dommer.printPerson();
    }
}
