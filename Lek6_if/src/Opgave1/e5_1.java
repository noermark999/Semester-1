package Opgave1;

import java.util.Scanner;

public class e5_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("indtast et tal: ");
        if (input.hasNextInt()) {
            int number = input.nextInt();
            if (number > 0) {
                System.out.println("Number is positive");
            } else if (number == 0) {
                System.out.println("Number is zero");
            } else {
                System.out.println("Number is negative");
            }
        } else if (input.hasNextLong()) {
            System.out.println("Error type number under 2 billion");
        } else {
            System.out.println("Error type a number");
        }
    }
}
