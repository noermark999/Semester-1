package Opgave6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerRead {

    public static void main(String[] args) {
        try {
            String pathname = "Lek33_Exceptions/res/Opgave6_RandomTal.txt";
            File file = new File(pathname);
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
