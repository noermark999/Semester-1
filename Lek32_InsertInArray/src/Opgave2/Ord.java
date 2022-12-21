package Opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Ord {
    public static String getOrd(boolean danish) {
        String ord = null;
        if (danish) {
            File file = new File("/Users/jakobnoermark/IdeaProjects/DMU/Lek32_InsertInArray/res/danskeord.txt");
            try (Scanner scanner = new Scanner(file)) {
                int length = 0;
                while (scanner.hasNext()) {
                    length++;
                    scanner.next();
                }
                try (Scanner scanner1 = new Scanner(file)) {
                    int min = 1;
                    int random = (int) Math.floor(Math.random() * (length - min + 1) + min);
                    for (int i = 0; i < random; i++) {
                        ord = scanner1.nextLine();
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                URL url = new URL("https://random-word-api.herokuapp.com/word");
                Scanner scanner = new Scanner(url.openStream());
                String randomWord = scanner.nextLine();
                ord = randomWord.substring(2, randomWord.length() - 2);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return ord;
    }
}
