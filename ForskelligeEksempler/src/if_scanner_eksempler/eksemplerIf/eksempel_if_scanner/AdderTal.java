package eksempel_if_scanner;

import java.util.Scanner;

public class AdderTal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Tal 1 ");
		int tal1 = scan.nextInt();
		
		System.out.print("Tal 2 ");
		int tal2 = scan.nextInt();
		
		System.out.println("Resultat addition " + (tal1 + tal2));

		scan.close();

	}
}
