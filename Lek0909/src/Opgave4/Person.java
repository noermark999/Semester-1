package Opgave4;


import java.security.PublicKey;

public class Person {
        private String name;
        private String address;
        private double monthlySalary;
        private double yearlySalary;
        private int companies;

        public Person(String name) {
            this.name = name;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setMonthlySalary(double monthlySalary) {
            this.monthlySalary = monthlySalary;
        }

        public double getMonthlySalary() {
            return monthlySalary;
        }

        public void YearlySalary() {
            this.yearlySalary = monthlySalary*12*1.025;
        }

        public double getYearlySalary() {
            return yearlySalary;
        }

        public void setCompanies(int inputCompanies) {
            companies = inputCompanies;
        }

        public int getCompanies() {
            return companies;
        }
        public void newCompany() {
            companies = companies + 1;
        }

        public void printPerson() {
            System.out.println("*******************");
            System.out.println("Navn: " + name);
            System.out.println("Addresse: " + address);
            System.out.println("Løn: " + monthlySalary);
            System.out.println("Årsløn:" + yearlySalary);
            System.out.println("Virksomheder: " + companies);
            System.out.println();
        }


}
