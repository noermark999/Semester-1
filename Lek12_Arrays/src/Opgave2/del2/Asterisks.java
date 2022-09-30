package Opgave2.del2;

import java.util.Scanner;

public class Asterisks {
    private int[] drawAsterisks;
    private final int MAX_NUMBER_OF_ASTERISKS = 40;
    private Scanner scan;

    public Asterisks() {
        drawAsterisks = new int[5];
        scan = new Scanner(System.in);
    }

    public double maxValue(){
        double max = 0;
        for (int i = 0; i<drawAsterisks.length;i++){
            if (drawAsterisks[i]>max){
                max = drawAsterisks[i];
            }
        }
        return max;
    }

    public void draw(){

        String[] rowName = new String[5];
        for (int i = 0; i<rowName.length;i++){
            System.out.println("Skriv et navn: ");
            rowName[i] = scan.nextLine();
        }

        int[] rowNumber = new int[5];
        for (int i = 0; i<rowNumber.length;i++){
            System.out.println("Skriv value for " + rowName[i] + ": ");
            rowNumber[i] = scan.nextInt();
        }

        for (int i = 0; i<drawAsterisks.length;i++){
            drawAsterisks[i] = rowNumber[i];
        }

        double maxAsterisks = MAX_NUMBER_OF_ASTERISKS/maxValue();

        for (int i = 0; i<drawAsterisks.length;i++){
            System.out.printf("%-10s ", rowName[i]);
            for (int i1 =0; i1<(drawAsterisks[i]*maxAsterisks);i1++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
