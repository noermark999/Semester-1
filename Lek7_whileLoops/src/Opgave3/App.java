package Opgave3;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Loekker loekker = new Loekker();
        System.out.println("Opgave a:");
        loekker.allPowers();
        System.out.println();
        System.out.println("Opgave b:");
        System.out.println(loekker.sumOdd(3,19));
        System.out.println();
        System.out.println("Opgave c:");
        System.out.println(loekker.sumOfOddDigits(32677));

        //loekker.udskriv1_10();
        //loekker.udskriv1_10_iteration();

        //System.out.println(loekker.summer());
        // System.out.println(loekker.summer(10));
        // System.out.println(loekker.multiplum(4, 3));

		// Kald af metoder der afprøver opgave 1
		// System.out.println(loekker.summerEven());
		// System.out.println(loekker.summerSquare());

		// Klad af metoder der afprøver opgave 3
        // loekker.allPowers();
        // System.out.println(loekker.sumOdd(3, 19));
        // System.out.println(loekker.sumOfOddDigits(32677));

    }
}
