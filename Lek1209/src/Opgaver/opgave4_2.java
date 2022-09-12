package Opgaver;

import java.util.Scanner;

public class opgave4_2 {
    public static void main(String[] args) {

        System.out.print("indtast tal: ");
        int x = readInt();

        System.out.println("Square power: " + x*x);
        System.out.println("Cubic power: " + x*x*x);
        System.out.println("Fourth power: " + (int)Math.pow(x,4));

    }
    public static int readInt() {
        return new Scanner(System.in).nextInt();
    }
}
