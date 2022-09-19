package modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 33);
		e1.printEmployee();
		e1.birthday();
		e1.setFirstName("Lars");
		e1.printEmployee();


	}

}
