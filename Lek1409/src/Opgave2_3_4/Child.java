package Opgave2_3_4;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		if (age == 0) {
			return "At home";
		} else if (age == 1 || age == 2) {
			return "In a nursery";
		} else if (age >= 3 && age <= 5) {
			return "In kindergarten";
		} else if (age >=6 && age <= 16) {
			return "In school";
		} else {
			return "Out of school";
		}
	}

	public String gender() {
		if (isBoy()) {
			return "Boy";
		} else {
			return "Girl";
		}
	}

	public String team() {
		if (gender().equals("Girl") && age < 8) {
			return "Tumbling girls";
		} else if (gender().equals("Girl") && age >= 8) {
			return "Springy girls";
		} else if (gender().equals("Boy") && age < 8) {
			return "Young cubs";
		} else {
			return "Cool boys";
		}
	}

}
