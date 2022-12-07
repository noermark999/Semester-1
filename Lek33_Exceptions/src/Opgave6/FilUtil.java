package Opgave6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilUtil {

    public static int max(String filename) {
        int max = 0;
        File file = new File("Lek33_Exceptions/res/" + filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                int i = scanner.nextInt();
                if (i > max) {
                    max = i;
                }
            }
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        return max;
    }

    public static int min(String filename) {
        int min = 1000000;
        File file = new File("Lek33_Exceptions/res/" + filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                int i = scanner.nextInt();
                if (i < min) {
                    min = i;
                }
            }
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        return min;
    }

    public static int average(String filename) {
        int amount = 0;
        int total = 0;
        File file = new File("Lek33_Exceptions/res/" + filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                int i = scanner.nextInt();
                total += i;
                amount++;
            }
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        return total/amount;
    }
}
