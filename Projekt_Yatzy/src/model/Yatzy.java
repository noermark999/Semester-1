package model;

import java.util.Random;

public class Yatzy {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6.
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private Random random = new Random();

    public Yatzy() {
        Die die = new Die();
    }

    /**
     * Returns the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Sets the 5 face values of the dice. Pre: values contains 5 face values in
     * [1..6]. Note: This method is only meant to be used for test, and
     * therefore has package visibility.
     */
    public void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Returns the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
     * boolean values.
     */
    public void throwDice(boolean[] holds) {
        Die die = new Die();
        for (int i = 0; i < values.length; i++) {
            if (!holds[i] && throwCount < 3) {
                die.roll();
                values[i] = die.getFaceValue();
            }
        }
        if (throwCount < 3) {
            throwCount++;
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Returns all results possible with the current face values. The order of
     * the results is the same as on the score board. Note: This is an optional
     * method. Comment this method out, if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Returns an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v
    // <= 6.
    // Index 0 is not used.
    public int[] calcCounts() {
        int[] freq = new int[7];
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (i == values[j]) {
                    freq[i] += 1;
                }
            }
        }
        return freq;
    }

    /**
     * Returns same-value points for the given face value. Returns 0, if no dice
     * has the given face value. Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int[] freq = calcCounts();
        int dieValue = freq[value];
        return value * dieValue;
    }

    /**
     * Returns points for one pair (for the face value giving highest points).
     * Returns 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        int points = 0;
        int[] freq = calcCounts();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] >= 2 && points < i * 2) {
                points = i * 2;
            }
        }
        return points;
    }

    /**
     * Returns points for two pairs (for the 2 face values giving highest
     * points). Returns 0, if there aren't 2 dice with one face value and 2 dice
     * with a different face value.
     */
    public int twoPairPoints() {
        int points = 0;
        int[] freq = calcCounts();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] >= 2 && points < i * 2) {
                for (int j = i + 1; j < freq.length; j++) {
                    if (freq[j] >= 2) {
                        points = (i * 2) + (j * 2);
                    }
                }
            }
        }
        return points;
    }

    /**
     * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with
     * the same face value.
     */
    public int threeSamePoints() {
        int points = 0;
        int[] freq = calcCounts();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] >= 3 && points < i * 3) {
                points = i * 3;
            }
        }
        return points;
    }

    /**
     * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with
     * the same face value.
     */
    public int fourSamePoints() {
        int points = 0;
        int[] freq = calcCounts();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] >= 4 && points < i * 4) {
                points = i * 4;
            }
        }
        return points;
    }

    /**
     * Returns points for full house. Returns 0, if there aren't 3 dice with one
     * face value and 2 dice a different face value.
     */
    public int fullHousePoints() {
        int points = 0;
        int[] freq = calcCounts();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2 || freq[i] == 3) {
                for (int j = i + 1; j < freq.length; j++) {
                    if (freq[j] == 2 || freq[j] == 3) {
                        if (freq[i] == 3 || freq[j] == 3) {
                            points = (i * freq[i]) + (j * freq[j]);
                        }
                    }
                }
            }
        }
        return points;
    }

    /**
     * Returns points for small straight. Returns 0, if the dice are not showing
     * 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int holder = 0;
        int[] freq = calcCounts();
        for (int i = 0; i < freq.length - 1; i++) {
            if (freq[i] == 1) {
                holder += 1;
            }
        }
        if (holder == 5) {
            return 15;
        }
        return 0;
    }

    /**
     * Returns points for large straight. Returns 0, if the dice is not showing
     * 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int holder = 0;
        int[] freq = calcCounts();
        for (int i = 2; i < freq.length; i++) {
            if (freq[i] == 1) {
                holder += 1;
            }
        }
        if (holder == 5) {
            return 20;
        }
        return 0;
    }

    /**
     * Returns points for chance.
     */
    public int chancePoints() {
        int points = 0;
        for (int i = 0; i < values.length; i++) {
            points += values[i];
        }
        return points;
    }

    /**
     * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
     * face value.
     */
    public int yatzyPoints() {
        int points = 0;
        int[] freq = calcCounts();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 5) {
                points = 50;
            }
        }
        return points;
    }

}
