package archExample.application.model;

public class Employee {
	private String name;
	private int wage; // hourly wage
	private int hours; // weekly work hours
	private int employmentYear;

	// link to company class (--> 0..1)
	private Company company;

	public Employee(String name, int wage, int hours) {
		this.name = name;
		this.wage = wage;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return name + " (kr " + wage + ")";
	}

	// -----------------------------------------------------------------------------

	public Company getCompany() {
		return company;
	}

	/**
	 * Sets the company as this employees company, if they aren't connected 
	 * 
	 * @param company
	 */
	public void setCompany(Company company) {
		if (this.company != company) {
			Company oldCompany = this.company;
			if (oldCompany != null) {
				oldCompany.removeEmployee(this);
			}
			this.company = company;
			if (company != null)
				company.addEmployee(this);
		}
	}

	public int getEmploymentYear() {
		return employmentYear;
	}

	public void setEmploymentYear(int employmentYear) {
		this.employmentYear = employmentYear;
	}
	// -----------------------------------------------------------------------------

	/**
	 * Returns the weekly salary of this employee.
	 */
	public int weeklySalary() {
		return wage * hours;
	}

}
