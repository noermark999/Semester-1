package Opgave2;

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        // Set up the game
        String word = "hangman"; // The word to be guessed
        int lives = 6; // The number of lives the player has
        String progress = ""; // The current progress of the player's guess
        Scanner input = new Scanner(System.in); // Scanner to read player's input
        boolean gameOver = false; // Flag to indicate when the game is over

        // Loop until the game is over
        while (!gameOver) {
            // Print the current state of the game
            System.out.println("Lives: " + lives);
            System.out.println("Word: " + progress);

            // Read the player's input
            System.out.print("Enter a letter: ");
            String letter = input.nextLine();

            // Check if the letter is in the word
            if (word.contains(letter)) {
                // Update the player's progress
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        progress += letter;
                    } else if (progress.charAt(i) != '_') {
                        progress += progress.charAt(i);
                    } else {
                        progress += "_";
                    }
                }
            } else {
                // The letter is not in the word, so subtract a life
                lives--;
            }

            // Check if the player has won or lost
            if (word.equals(progress)) {
                System.out.println("You win!");
                gameOver = true;
            } else if (lives == 0) {
                System.out.println("You lose!");
                gameOver = true;
            }
        }
    }
}

