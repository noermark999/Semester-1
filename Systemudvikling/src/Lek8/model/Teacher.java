package Lek8.model;

public class Teacher extends Person {
    private final int salary;
    private double yearlySal;
    private String subject;

    public Teacher(String name, String address, String qualification, int salary, String subject) {
        super(name, address, qualification);
        this.salary = salary;
        this.subject = subject;

    }

    public String getSubject() {
        return subject;
    }

    public void yearlySalary() {
        yearlySal = 12.0 * salary;
        yearlySal = yearlySal * 1.125;
    }

    public void addSubject(String addSubject) {
        subject = subject + ", " + addSubject;
    }

    @Override
    public void udskrivPerson() {
        super.udskrivPerson();
        System.out.println("Salary: " + salary);
        yearlySalary();
        System.out.println("Yearly salary: " + yearlySal);
        System.out.println("Underviser i disse fag: " + subject);
    }

}
