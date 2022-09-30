package Opgave1;

public class StudentApp {

	public static void main(String[] args) {
		Student peter = new Student("Peter", 20);
		Student jens = new Student("Jens", 22);
		jens.setActive(true);

		System.out.println(peter.getName() + " " + peter.getAge());
		System.out.println(jens.getName() + " " + jens.getAge());

		jens.addGrade(7);
		jens.addGrade(12);
		jens.addGrade(10);

		peter.addGrade(7);
		peter.addGrade(4);
		peter.addGrade(-3);

		System.out.println(jens.getName() + " har et gennemsnit paa: " + jens.averageGrade());
		System.out.println(peter.getName() + " har et gennemsnit paa: " + peter.averageGrade());


		//Tester opgave 1.b
		System.out.println(jens.getName() + " højeste karakter er " + jens.maxGrade());
		System.out.println(peter.getName() + " højeste karakter er " + peter.maxGrade());

		//Tester opgave 1.c
		System.out.println(jens.getName() + " laveste karakter er " + jens.minGrade());
		System.out.println(peter.getName() + " laveste karakter er " + peter.minGrade());

		System.out.println("Karaktererne for " + jens.getName());
		for (int i = 0; i < jens.getNumberOfGrades(); i++) {
			System.out.println(jens.getGrades()[i]);
		}

	}

}
