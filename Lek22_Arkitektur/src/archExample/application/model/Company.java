package archExample.application.model;

import java.util.ArrayList;

public class Company {
	private String name;

	// link to Employee class (--> 0..*)
	private final ArrayList<Employee> employees = new ArrayList<>();

	// Link to Customer class (--> 0..*)
	private final ArrayList<Customer> customers = new ArrayList<>();

	public enum companySize {MIKRO, LILLE, MELLEMSTOR, STOR}

	public companySize size;

	public Company(String name, companySize companySize) {
		this.name = name;
		size = companySize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	// -----------------------------------------------------------------------------

	public ArrayList<Employee> getEmployees() {
		return new ArrayList<>(employees);
	}

	/**
	 * Adds the employee to this comapy, if they aren't connected 
	 * 
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		if (!employees.contains(employee)) {
			employees.add(employee);
			employee.setCompany(this);
		}
	}

	/**
	 * Removes the employee from this company,
	 * if the are connected
	 * @param employee
	 */
	public void removeEmployee(Employee employee) {
		if (employees.contains(employee)) {
			employees.remove(employee);
			employee.setCompany(null);
		}
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void addCustomer(Customer customer) {
		if (!customers.contains(customer)) {
			customers.add(customer);
			customer.addCompany(this);
		}
	}

	public void removeCustomer(Customer customer) {
		if (customers.contains(customer)) {
			customers.remove(customer);
			customer.removeCompany(this);
		}
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the count of employees in this company.
	 */
	public int employeesCount() {
		return employees.size();
	}

	/**
	 * Returns the total weekly salary of all employees in the company.
	 */
	public int totalWeeklySalary() {
		int total = 0;
		for (Employee emp : employees) {
			total += emp.weeklySalary();
		}
		return total;
	}

	public void setSize(companySize size) {
		this.size = size;
	}
}
