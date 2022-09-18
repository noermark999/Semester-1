package Opgave1;

import java.util.Scanner;

public class e5_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Type first number: ");
        if (input.hasNextInt()) {
            int number1 = input.nextInt();
            System.out.print("type second number: ");
            if (input.hasNextInt()) {
                int number2 = input.nextInt();
                System.out.print("Type third number: ");
                if (input.hasNextInt()) {
                    int number3 = input.nextInt();
                    if (number1 < number2 && number2 < number3) {
                        System.out.println("Numbers are increasing");
                    } else if (number1 > number2 && number2 > number3) {
                        System.out.println("Numbers are decreasing");
                    } else {
                        System.out.println("Numbers are neither decreasing or increasing");
                    }
                } else {
                    System.out.println("Error type a number");
                }
            } else {
                System.out.println("Error type a number");
            }
        } else {
            System.out.println("Error type a number");
        }
    }
}
