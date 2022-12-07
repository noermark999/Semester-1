package Opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("Lek33_Exceptions/res/HeltalOpg2.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt() * 2);
            }
        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
