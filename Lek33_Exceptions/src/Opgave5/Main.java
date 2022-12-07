package Opgave5;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean finished = false;
        try (Scanner scan = new Scanner(System.in)){
                try (PrintWriter printWriter = new PrintWriter("Lek33_Exceptions/res/Opg5fil.txt")) {
                    while (!finished) {
                    int i = scan.nextInt();
                    if (i > 0) {
                        printWriter.println(i);
                    } else {
                        finished = true;
                    }
                }
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
            }
        } catch (RuntimeException e) {
            System.out.println("skriv et tal istedet");
        }
    }
}
