package eksempel_if_scanner;

import java.util.Scanner;

public class EksempelIf {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Er du studerende ja eller nej: ");
		String svar = scan.nextLine();
		if (svar.toLowerCase().equals("ja")) {
			System.out.println("Så er du fattig men lærer en masse");
		} else if (svar.equals("nej")) {
			System.out.println("Så er du rig");
		} else {
			System.out.println("Du har svaret forkert");
		}
		
		scan.close();

	}

}
