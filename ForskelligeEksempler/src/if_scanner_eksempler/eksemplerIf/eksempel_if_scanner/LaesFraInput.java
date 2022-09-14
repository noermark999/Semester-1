package eksempel_if_scanner;

import java.util.Scanner;

public class LaesFraInput {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//		System.out.println("Hvad er dit fornavn ? ");
//		String fornavn = scan.nextLine();
//		
//		System.out.println("Hvad er dit mellemnavn ? ");
//		String mellemnavn = scan.next();
//		
//		System.out.println("Hvad er dit efternavn ? ");
//		String efternavn = scan.next();

		System.out.println("Hvor gammel er du ? ");
		if (scan.hasNextInt()) {
			int alder = scan.nextInt();
		}
//
//		Name navn = new Name(fornavn,mellemnavn, efternavn);
//		System.out.println(fornavn + " " + efternavn + " " + alder);
//		System.out.println(navn.getUserName());

//		System.out.println(" skriv dit navn og alder:");
//		String fornavn = scan.next();
//		String mellemnavn = scan.next();
//		String efternavn = scan.next();
//		int alder = scan.nextInt();
//		Name navn = new Name(fornavn,mellemnavn, efternavn);
//		System.out.println(fornavn + " " + efternavn + " " + alder);

		System.out.println("Er du underviser: ");
		boolean underviser = scan.nextBoolean();
		System.out.println("Underviser: " + underviser);
		scan.close();

	}

}