package Opgave4;

public class PersonApp {
    public static void main(String[] args) {

        Person person1 = new Person("Peter");

        person1.setAddress("Gajsgårdsvej 9, Harboøre");
        person1.setMonthlySalary(20000);
        person1.getYearlySalary();
        person1.setCompanies(3);
        person1.printPerson();
        person1.newCompany();
        person1.printPerson();


    }
}
