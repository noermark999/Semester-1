package Opgave3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        File file = new File("Lek33_Exceptions/res/HeltalOpg2.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            }
            for (int i = integers.size()-1; i >= 0; i--) {
                System.out.println(integers.get(i));
            }
        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println(e);
        }
    }
}
