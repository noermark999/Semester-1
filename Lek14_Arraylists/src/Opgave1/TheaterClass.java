package Opgave1;

import java.util.Scanner;

public class TheaterClass {
    private final int[][] seats = new int[][] {
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
            {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30},
    };
    private final Scanner scan = new Scanner(System.in);

    public int[][] getSeats() {
        return seats;
    }
    public void printSeats() {
        System.out.println("Række/sæde" + "  1" + "  2" + "  3" + "  4" + "  5" + "  6" + "  7" + "  8" + "  9" + "  10");
        for (int i = 0; i<seats.length; i++) {
            System.out.print(i+1 + "          ");
            for (int j = 0; j<seats[0].length; j++) {
                if (seats[i][j] != 0){
                    System.out.printf("%3d", seats[i][j]);
                } else {
                    System.out.printf("%3s", "--");
                }
            }
            System.out.println();
        }
    }
    public void buySeats(int price) {
        boolean running = true;
        if (price == 10 || price == 20 || price == 30 || price == 40 || price == 50) {
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[0].length; j++) {
                    if (seats[i][j] == price && running) {
                        System.out.println("Du købte en plads til " + price + "kr.");
                        seats[i][j] = 0;
                        running = false;
                    }
                }
            }
            if (running) {
                System.out.println("Der er udsolgt i denne prisklasse");
            }
        } else {
            System.out.println("ingen pladser til denne pris");
        }
    }
    public void buySeats(int row, int seat) {
        row -= 1;
        seat -= 1;
        if (row > seats.length || seat > seats[0].length || row<0 || seat<0) {
            System.out.println("Fejl du har tastet et sædde der ikke findes");
        } else {

            if (seats[row][seat] != 0) {
                System.out.println("Du har købt en plads til prisen " + seats[row][seat]);
                seats[row][seat] = 0;
            } else {
                System.out.println("Sædet er ikke ledig");
            }
        }
    }
    public void start() {
        boolean done = false;
        while (!done) {
            System.out.println("Vil du købe en bestemt plads eller til en bestemt pris?");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("plads")) {
                System.out.println("Skriv hvilken plads du vil have ud fra denne tabel:");
                printSeats();
                System.out.println("Række: ");
                int seatNumber1 = scan.nextInt();
                System.out.println("Sæde: ");
                int seatNumber2 = scan.nextInt();
                scan.nextLine();
                buySeats(seatNumber1, seatNumber2);
            } else if (answer.equalsIgnoreCase("pris")) {
                System.out.println("Skriv hvilken pris du vil købe et sæde til ud fra tabellen:");
                printSeats();
                System.out.println("Skriv pris: ");
                int price = scan.nextInt();
                scan.nextLine();
                buySeats(price);
            } else {
                System.out.println("Forkert input");
            }
            System.out.println("Vil du købe en plads mere? ja/nej");
            String answer1 = scan.nextLine();
            if (answer1.equalsIgnoreCase("nej")) {
                done = true;
            }
        }
    }

}
