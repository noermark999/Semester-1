package Projekt1;

import java.util.Scanner;

/**
 * A small game where you roll dices. There are no rules; just roll the die until you get bored.
 */
public class PlayPairOfDices {

	/**
	 * The scanner used for reading user input.
	 */
	private final Scanner scan;
	private final PairOfDices pair;

	/**
	 * Constructs the Projekt1.PlayRollDie game.
	 */
	public PlayPairOfDices() {
		pair = new PairOfDices();
		scan = new Scanner(System.in);
	}

	/** 
	 * Print out a neat welcome message to the player.
	 */
	private void welcomeToGame() {
		System.out.println("Velkommen til spillet KAST terninger");
	}

	/**
	 * Finishes the game and prints out the result.
	 */
	private void gameOver() {

		System.out.println("Tak for spillet du kastede " + pair.getRolls() + " "
				+ "gange.");
		System.out.println("Antal af 1: " + pair.getOnes());
		System.out.println("Antal af 2: " + pair.getTwos());
		System.out.println("Antal af 3: " + pair.getThrees());
		System.out.println("Antal af 4: " + pair.getFours());
		System.out.println("Antal af 5: " + pair.getFives());
		System.out.println("Antal af 6: " + pair.getSixes());
		System.out.println("Antal par: " + pair.getPairs());
		System.out.println("Højeste slag: " + pair.getHigh());
		scan.close();
	}

	/**
	 * Take another turn in the game.
	 */
	private void takeTurn() {
		pair.rollBothDices();
	}

	/**
	 * Start the game loop.<br/>
	 * The game is finished when the player chooses to not roll the die anymore.
	 */
	public void startGame() {
		welcomeToGame();

		boolean finished = false;

		while (!finished) {
			System.out.println("Vil du kaste med terninger? Angiv Ja eller Nej: ");
			String goOn = scan.nextLine();
			if (goOn.equalsIgnoreCase("Nej")) {
				finished = true;
			} else if (goOn.equalsIgnoreCase("ja")){
				takeTurn();
			} else {
				System.out.println("Skriv ja eller nej");
			}
		}
		gameOver();
	}
}
