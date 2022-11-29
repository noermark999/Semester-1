package Lek15.Application.Model;

public class Customer {
    private String name;
    private int age;

    private long licenseID;
    private long cprNR;


    public Customer(String name, int age, long licenseID, long cprNR) {
        this.name = name;
        this.age = age;
        this.licenseID = licenseID;
        this.cprNR = cprNR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(long licenseID) {
        this.licenseID = licenseID;
    }

    public long getCprNR() {
        return cprNR;
    }

    public void setCprNR(long cprNR) {
        this.cprNR = cprNR;
    }
}
