package Opgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try (PrintWriter printWriter = new PrintWriter("Lek33_Exceptions/res/Opg4fil.txt")) {
            int tal = 100;
            for (int i = 0; i < tal; i++) {
                if (i % 2 == 1) {
                    printWriter.println(i);
                }
            }
            printWriter.println();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
