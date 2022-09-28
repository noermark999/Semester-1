package Projekt3;

import java.util.Scanner;

public class PlayPig {
    private int roll;
    private Scanner scan;
    private Die die;
    private int sum;
    private int player1;
    private int player2;
    private int pointsNeeded;

    //Starter med at lave 1 terning, og der skal angives hvor mange point der skal bruges for at vinde
    public PlayPig(int pointsNeeded) {
        die = new Die();
        scan = new Scanner(System.in);
        this.pointsNeeded = pointsNeeded;
    }

    /**
     *
     * @param player Navnet på spiller
     * @return Der returneres summen af turen for spilleren
     */
    private int takeTurn(String player) {
        System.out.println("Det er " + player + " tur");

        sum = 0;

        boolean finished = false;


        while (!finished) {
            die.roll();
            roll = die.getFaceValue();
            printRoll();
            String goOn;

                if (roll == 1) {
                    finished = true;
                    sum = 0;
                    System.out.println("Sum for denne tur: " + sum);
                    System.out.println();
                } else {
                    sum = sum + roll;
                    if (player.equalsIgnoreCase("Computer")) {
                        int random = (int) Math.ceil(Math.random()*100)%2; //tager et tilfældtigt tal mellem 1 og 100, tager modulu 2 så det enten bliver 1 eller 0
                        String[] computerRandom = {"Ja", "Nej"};
                        goOn = computerRandom[random]; // hvis random bliver 0 er goOn ja og hvis den er 0 er goOn nej
                    } else {
                        System.out.println("Vil du slå igen? Angiv Ja eller Nej: ");
                        goOn = scan.nextLine();

                    }
                    //Tjekker om goOn bliver nej alt efter input eller computerens random
                    if (goOn.equalsIgnoreCase("Nej")) {
                        finished = true;
                        System.out.println("Sum for denne tur: " + sum);
                        System.out.println();
                    }
                }

            }
        return sum;
    }

    public void printRoll() {
        System.out.println("Du har slået: " + roll);
    }

    /**
     *
     */
    public void startGame() {
        String player1navn;
        String player2navn;
        System.out.println("Vil du spille mod computer? Ja/Nej");
        String spilCom;
        spilCom = scan.nextLine();
        if (spilCom.equalsIgnoreCase("Ja")) {
            player2navn = "Computer";
            System.out.println("Indtast spiller 1 navn:");
            player1navn = scan.nextLine();
        } else {
            System.out.println("Indtast spiller 1 navn:");
            player1navn = scan.nextLine();
            System.out.println("Indtast spiller 2 navn:");
            player2navn = scan.nextLine();
        }


        boolean done = false;

        while (!done) {
            player1 += takeTurn(player1navn);
            System.out.println(player1navn + " point i alt: " + player1);
            System.out.println();
            if (player1 >= pointsNeeded) {
                done = true;
                System.out.println(player1navn + " har vundet");
                System.out.println(player2navn + " fik " + player2 + " Points");
            }
            if (player2 < pointsNeeded && !done){
                player2 += takeTurn(player2navn);
                System.out.println(player2navn + " point i alt: " + player2);
                System.out.println();

            }
            if (player2 >= pointsNeeded) {
                done = true;
                System.out.println(player2navn + " har vundet");
                System.out.println(player1navn + " fik " + player1 + " Points");
            }


        }
    }
}
