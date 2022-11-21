package Projekt2;

import Projekt1.Die;

import javax.swing.text.StyledEditorKit;
import java.awt.image.PixelInterleavedSampleModel;
import java.util.Scanner;

/**
 * This class models one pair of dices.
 *
 */
public class CrapsPlay {
	/**
	 * The first die in the pair.
	 */
	private final Die die1;
	/**
	 * The second die in the pair.
	 */
	private final Die die2;
	private final Scanner scan;
	private boolean win;
	private int roll;
	private int point;
	private int numWins;
	private int numLoss;

	/**
	 * Constructor for objects of class Projekt1.PairOfDices
	 */
	//opgave 1
	public CrapsPlay() {
		this.die1 = new Die();
		this.die2 = new Die();
		scan = new Scanner(System.in);
	}

	private void welcomeToGame() {
		System.out.println("Velkommen til spillet Craps");
		System.out.println();
	}

	private void gameOver() {
		if (win) {
			System.out.println("Du har slået " + this.roll + " og du har vundet");
			System.out.println();
			numWins++;
		} else {
			System.out.println("Du har slået " + this.roll + " og du har tabt");
			System.out.println();
			numLoss++;
		}
	}

	private void takeTurn() {
		die1.roll();
		die2.roll();
		this.roll = die1.getFaceValue() + die2.getFaceValue();
		boolean finished = false;

		if (this.roll == 7 || this.roll == 11 ) {
			win = true;
			finished = true;
			gameOver();
		} else if (this.roll == 2 || this.roll == 3 || this.roll == 12 ) {
			win = false;
			finished = true;
			gameOver();
		} else {
			System.out.println("Du har slået: " + this.roll + " og det er dit point");
			point = this.roll;
		}
		while (!finished) {
			die1.roll();
			die2.roll();
			this.roll = die1.getFaceValue() + die2.getFaceValue();

			System.out.println("Du har slået: " + this.roll);

			if (this.roll == 7) {
				win = false;
				gameOver();
				finished = true;
			} else if (this.roll == point) {
				win = true;
				gameOver();
				finished = true;
			}
		}
	}

	public void startGame() {
		welcomeToGame();
		takeTurn();
		boolean done = false;

		while (!done) {
			System.out.println("Vil du spille igen? Angiv Ja eller Nej: ");
			String goOn = scan.nextLine();
			if (goOn.equalsIgnoreCase("Nej")) {
				done = true;
				System.out.println("Gange vundet: " + numWins);
				System.out.println("Gange tabt: " + numLoss);
			} else if (goOn.equalsIgnoreCase("ja")){
				takeTurn();
			} else {
				System.out.println("Skriv ja eller nej");
			}
		}

	}


}


