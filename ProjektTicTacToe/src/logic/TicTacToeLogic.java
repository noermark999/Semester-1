package logic;

import java.sql.SQLOutput;
import java.util.Arrays;

public class TicTacToeLogic {
    /* Represent the state of a tic-tac-toe game including
    the current player.
     */

    private final int SIZE = 3;

    private int mCurrentPlayer = 1;

    private int usedFields = 0;
    private final int[][] board = new int[3][3]; //Laver et 2d array som er 3x3 og giver det navnet board

    public TicTacToeLogic() {
    }

    /**
     * A mutator that must be called when a field is set by the
     * current player
     * @param row is the x-coordinate of the field. Must be in 0..size-1
     * @param col is the y-coordinate of the field. Must be in 0..size-1
     */
    public void set(int row, int col) {
        /*
        Der tjekkes om det er spiller 1's tur og hvis det er sættes der et 1 på den plads i arrayet som svarer til det
        felt spiller 1 har trykket på
        Hvis det ikke er spiller 1 så det spiller 2 og i stedet for at sætte et 1 i arrayet sættes der et -1
         */
        if (mCurrentPlayer == 1) {
            board[row][col] = 1;
        } else {
            board[row][col] = -1;
        }
        mCurrentPlayer = 3 - mCurrentPlayer;
        usedFields++;
    }

    /**
     * Inspector used to get the current player; either 1 or 2.
     * @return the current player
     */
    public int getCurrentPlayer() {
        return mCurrentPlayer; }

    /**
     * Inspector returning if there is a winner in the current state.
     * @return either 1 or 2 if there is a winner, and 0 otherwise
     */
    public int anyWinner() {
        /* Et for loop som køres 3 gange da 2D-arrayets længde er 3
        så køres der et if statement som checker om de 3 vandrette tal giver 3 eller - 3
        Da kryds giver plus 1 på et felt og bolle giver -1 på et felt vil der være 3 på en række
        hvis de tre tal giver 3 eller -3
        Loopet lægger så 1 til i hvilket rykker det hele ned på næste række
         */

        for (int i = 0; i<board[0].length;i++){
            if (board[i][0]+board[i][1]+board[i][2] == 3) {
                return 1;
            } else if (board[i][0]+board[i][1]+board[i][2] == - 3) {
                return 2;
            }
        }
        // Her er det det samme som før bare for de lodrette rækker i stedet vandrette
        // da i står på anden plads i board[][]
        for (int i = 0; i<board.length;i++){
            if (board[0][i]+board[1][i]+board[2][i] == 3) {
                return 1;
            } else if (board[0][i]+board[1][i]+board[2][i] == - 3) {
                return 2;
            }
        }
        //Her tjekkes der den skrå fra oppe i venstre hjørne ned til højre
        if (board[0][0] + board[1][1] + board[2][2] == 3) {
            return 1;
        } else if (board[0][0] + board[1][1] + board[2][2] == -3 ) {
            return 2;
        }
        //Og den anden skrå fra oppe i højre til nede i venstre
        if (board[0][2] + board[1][1] + board[2][0] == 3) {
            return 1;
        } else if (board[0][2] + board[1][1] + board[2][0] == -3 ) {
            return 2;
        }
        return 0;
    }


    /**
     * Inspector
     * @return if gameboard is filled.
     */
    public boolean isGameOver() {
        return usedFields == SIZE*SIZE; }

}
