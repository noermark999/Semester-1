package Opgaver;

import javax.swing.*;

public class opgave4_3Alt {
    public static void main(String[] args) {


        int a = Integer.parseInt(JOptionPane.showInputDialog("Indtast tal"));

        int b = Integer.parseInt(JOptionPane.showInputDialog("Indtast tal"));

        System.out.println();
        System.out.println("Resultater:");
        System.out.println("Sum: " + (a+b));
        System.out.println("Difference: " + (a-b));
        System.out.println("Product: " + (a*b));
        System.out.println("Average: " + (double)(a+b)/2);
        System.out.println("Absolute distance: " + Math.abs(a-b));
        System.out.println("Max: " + Math.max(a, b));
        System.out.println("Min: " + Math.min(a, b));

    }
}
