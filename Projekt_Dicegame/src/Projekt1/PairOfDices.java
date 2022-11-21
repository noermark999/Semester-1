package Projekt1;

import java.util.Scanner;

/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
	private final Die die1;
	/**
	 * The second die in the pair.
	 */
	private final Die die2;
	private int rolls;
	private int roll1;
	private int roll2;
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int pairs;
	private int high;
	private final Scanner scan;

	/**
	 * Constructor for objects of class Projekt1.PairOfDices
	 */
	//opgave 1
	public PairOfDices() {
		this.die1 = new Die();
		this.die2 = new Die();
		scan = new Scanner(System.in);
	}

	//opgave 2
	public PairOfDices(int sides) {
		this.die1 = new Die(sides);
		this.die2 = new Die(sides);
		scan = new Scanner(System.in);
	}

	//Opgave 9
	public void highRoll() {
		if (sumOfDices() > high) {
			high = sumOfDices();
		}
	}


	//Opgave 3
	public void rollBothDices() {
		die1.roll();
		die2.roll();
		this.roll1 = die1.getFaceValue();
		this.roll2 = die2.getFaceValue();

		//Opgave 5
		rolls++;

		//opgave 6 og 7
		if (roll1 == 1) {
			ones++;
		} else if (roll1 == 2) {
			twos++;
		} else if (roll1 == 3) {
			threes++;
		} else if (roll1 == 4) {
			fours++;
		} else if (roll1 == 5) {
			fives++;
		} else {
			sixes++;
		}
		if (roll2 == 1) {
			ones++;
		} else if (roll2 == 2) {
			twos++;
		} else if (roll2 == 3) {
			threes++;
		} else if (roll2 == 4) {
			fours++;
		} else if (roll2 == 5) {
			fives++;
		} else {
			sixes++;
		}

		//opgave 8
		if (roll1 == roll2) {
			pairs++;
		}

		//opgave 9
		highRoll();

		System.out.println("Du har kastet: " + roll1 + " og " + roll2);
	}

	//Opgave 10
	public void resetPairOfDices() {
		ones = 0;
		twos = 0;
		threes = 0;
		fours = 0;
		fives = 0;
		sixes = 0;
		pairs = 0;
		high = 0;
		rolls = 0;
	}


	//opgave 4
	public int sumOfDices() {
		return roll1+roll2;
	}

	public int getOnes() {
		return ones;
	}
	public int getTwos() {
		return twos;
	}
	public int getThrees() {
		return threes;
	}
	public int getFours() {
		return fours;
	}
	public int getFives() {
		return fives;
	}
	public int getSixes() {
		return sixes;
	}
	public int getOneToFive() {
		return ones + twos + threes + fours + fives;
	}
	public int getPairs() {
		return pairs;
	}

	public int getHigh() {
		return high;
	}

	public int getRolls() {
		return rolls;
	}

}
