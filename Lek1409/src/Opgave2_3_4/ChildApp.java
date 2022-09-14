package Opgave2_3_4;

public class ChildApp {

	public static void main(String[] args) {

		Child c1 = new Child(18, true);// boy 4 years old

		System.out.println("A " + c1.gender() +  " age " + c1.getAge() + ", whose: " + c1.institution());
		System.out.println();
		System.out.println("This person is on team: " + c1.team());
	}

}
