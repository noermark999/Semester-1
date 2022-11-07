package archExample.application.model;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Company> companies = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addCompany(Company company) {
        if (!companies.contains(company)) {
            companies.add(company);
            company.addCustomer(this);
        }
    }

    public void removeCompany(Company company) {
        if (companies.contains(company)) {
            companies.remove(company);
            company.removeCustomer(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
