package Kap5;

import java.util.Scanner;

public class elevator {
    public static void main(String[] args) {
        System.out.print("Type floor number: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int floor = in.nextInt();
            if (floor == 13) {
                System.out.println("Error: Floor 13 does not exist");
            }
            else {
                if (floor <= 0 || floor >= 20) {
                    System.out.println("Error: Floor must be between 1 and 20");
                } else {
                    int actualFloor = floor;
                    if (floor > 13) {
                        actualFloor = floor - 1;
                    }
                    System.out.println("You're travelling to the actual floor: " + actualFloor);
                }
            }
        }
        else {
            System.out.println("Error: Type a number");
        }
    }
}
