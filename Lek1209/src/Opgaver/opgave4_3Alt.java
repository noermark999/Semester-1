package Opgaver;

import javax.swing.*;

public class opgave4_3Alt {
    public static void main(String[] args) {


        int a = Integer.parseInt(JOptionPane.showInputDialog("Indtast tal"));

        int b = Integer.parseInt(JOptionPane.showInputDialog("Indtast tal"));

        System.out.println();
        System.out.println("Resultater:");
        System.out.println("Sum: " + String.format("%,d", (a+b)));
        System.out.println("Difference: " + String.format("%,d", (a-b)));
        System.out.println("Product: " + String.format("%,d", (a*b)));
        System.out.println("Average: " + (double)(a+b)/2);
        System.out.println("Absolute distance: " + String.format("%,d", Math.abs(a-b)));
        System.out.println("Max: " + String.format("%,d", Math.max(a, b)));
        System.out.println("Min: " + String.format("%,d", Math.min(a, b)));

    }
}
