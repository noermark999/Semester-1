package Opgave3;

public class Loekker {
	public void udskriv1_10() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");

	}

	public void udskriv1_10_iteration() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}

	public int summer() {
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum = sum + i;
			i++;
			
		}
		return sum;

	}

	public int summer(int n) {
		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum = sum + i;
			i++;
		}
		return sum;

	}

	public int multiplum(int a, int b) {
		int resultat = 0;
		int i = 0;
		while (i < a) {
			resultat = resultat + b;
			i++;
		}
		return resultat;

	}

	public int summerEven() {
		// TODO Opgave 1.a
		return -1;
	}

	public int summerSquare() {
		// TODO Opgave 1.b
		return -1;
	}

	public void allPowers() {
		int p = 0;
		while (p<=20) {
			System.out.println(p + ": " + (int)Math.pow(2,p));
			p++;
		}
	}

	public int sumOdd(int a, int b) {
		int sum = 0;
		int i = 0;
		int x = 0;
		if (a % 2 == 0) {
			x = 1;
		} else {
			x = 0;
		}
		while (i <= b) {
			sum = sum + i;
			i = a+x;
			x = x + 2;
		}
		return sum;
	}

	public int sumOfOddDigits(int number) {
		int sum = 0;
		int digits = String.valueOf(number).length();
		int i = 0;
		while (digits !=0) {
			int x = Integer.parseInt(String.valueOf(number).substring(i,i+1));
			if (x%2 != 0) {
				sum = sum + x;
			}
			i++;
			digits--;
		}
		return sum;
	}
}
