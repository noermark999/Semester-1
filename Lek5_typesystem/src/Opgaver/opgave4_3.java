package Opgaver;

import java.util.Scanner;

public class opgave4_3 {
    public static void main(String[] args) {

        System.out.print("Indtast tal: ");
        double a = readDouble();
        System.out.print("Indtast tal: ");
        double b = readDouble();

        System.out.println();
        System.out.println("Resultater:");
        System.out.println("Sum: " + (a+b));
        System.out.println("Difference: " + (a-b));
        System.out.println("Product: " + (a*b));
        System.out.println("Average: " + (a+b)/2);
        System.out.println("Absolute distance: " + Math.abs(a-b));
        System.out.println("Max: " + Math.max(a, b));
        System.out.println("Min: " + Math.min(a, b));

    }

    public static String readLine() {
        return new Scanner(System.in).nextLine();
    }
    public static int readInt() {
        return new Scanner(System.in).nextInt();
    }
    public static double readDouble() {
        return new Scanner(System.in).nextDouble();
    }
}
