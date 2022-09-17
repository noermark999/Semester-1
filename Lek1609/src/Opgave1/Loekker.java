package Opgave1;

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
		int sum = 0;
		int i = 2;
		while (i<=100) {
			sum = sum + i;
			i = i +2;
		}
		return sum;
	}

	public int summerSquare() {
		int kvadratSum = 0;
		int i = 1;
		int a = 1;
		while (i<=100) {
			kvadratSum = kvadratSum + i;
			a++;
			i = a*a;
		}
		return kvadratSum;
	}

	public void allPowers() {
		// TODO Opgave 3.a
	}

	public int sumOdd(int a, int b) {
		// TODO Opgave 3.b
		return -1;
	}

	public int sumOfOddDigits(int number) {
		// TODO Opgave 3.c
		return -1;
	}
}
