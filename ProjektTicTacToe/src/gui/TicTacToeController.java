package gui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import logic.*;

@SuppressWarnings("Convert2Diamond")
public class TicTacToeController {

    private final int SIZE = 3;

    private TicTacToeLogic mLogic;

    @FXML
    private GridPane gameBoard;

    @FXML private Label lblInfo;



    public void squareClickedHandler(MouseEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        clickedButton.setDisable(true);
        var coor = (Pair<Integer, Integer>)clickedButton.getUserData();
        //lblInfo.setText(coor.getKey() + ", " + coor.getValue());

        String symbol = mLogic.getCurrentPlayer() == 1 ? "X": "O";

        clickedButton.setText(symbol);

        mLogic.set(coor.getKey(), coor.getValue());

        if (mLogic.anyWinner() != 0)
        {
            lblInfo.setText("A WINNER is FOUND: " + symbol);

        } else if (mLogic.isGameOver())
        {
            lblInfo.setText("GAME OVER - NO WINNER");
        }
        else
            lblInfo.setText("Player " + mLogic.getCurrentPlayer() + " - make your choice");
    }

    public void play() {
        mLogic = new TicTacToeLogic();
        gameBoard.getChildren().clear();
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
            {
                Button b = new Button();
                b.setUserData(new Pair(r,c));
                b.setPrefWidth(100.0);
                b.setPrefHeight(100.0);
                b.getStyleClass().add("FieldButton");
                b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        squareClickedHandler(mouseEvent);
                    }
                });
                gameBoard.add(b, r, c);
                lblInfo.setText("Player 1 - make your choice");
            }
    }
}
