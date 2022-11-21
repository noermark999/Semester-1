package Opgave2.del1;

import java.util.Scanner;

public class Asterisks {
    private final int[] drawAsterisks;
    private final int MAX_NUMBER_OF_ASTERISKS = 40;

    public Asterisks(int row1, int row2, int row3, int row4, int row5) {
        drawAsterisks = new int[5];
        drawAsterisks[0] = row1;
        drawAsterisks[1] = row2;
        drawAsterisks[2] = row3;
        drawAsterisks[3] = row4;
        drawAsterisks[4] = row5;
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
        double maxAsterisks = MAX_NUMBER_OF_ASTERISKS/maxValue();

        for (int i = 0; i<drawAsterisks.length;i++){
            for (int i1 =0; i1<(drawAsterisks[i]*maxAsterisks);i1++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
