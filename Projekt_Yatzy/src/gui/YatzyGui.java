package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Yatzy;

import java.util.Arrays;

public class YatzyGui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private Yatzy dice = new Yatzy();

    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds;
    // Shows the results previously selected .
    // For free results (results not set yet), the results
    // corresponding to the actual face values of the 5 dice are shown.
    private TextField[] txfResults;
    // Shows points in sums, bonus and total.
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    // Shows the number of times the dice has been rolled.
    private Label lblSumSame, lblSumOther, lblBonus, lblTotal;
    private Label lblRolled;
    private Label[] lblResults;
    private boolean[] holds;

    private Button btnRoll;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);


        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // initialize txfValues, chbHolds, btnRoll and lblRolled

        txfValues = new TextField[5];

        for (int i = 0; i < txfValues.length; i++) {
            TextField textField = new TextField();
            txfValues[i] = textField;
            txfValues[i].setText(String.valueOf(dice.getValues()[i]));
            dicePane.add(txfValues[i], i, 0);
            txfValues[i].setEditable(false);
            txfValues[i].setMinHeight(75);
            txfValues[i].setMinWidth(75);
            txfValues[i].setMaxWidth(75);
            txfValues[i].setFont(Font.font(30));
            txfValues[i].setAlignment(Pos.CENTER);
        }

        chbHolds = new CheckBox[5];
        for (int i = 0; i < chbHolds.length; i++) {
            CheckBox checkBox = new CheckBox();
            chbHolds[i] = checkBox;
            dicePane.add(chbHolds[i], i, 1);
            chbHolds[i].setText("Hold");
        }

        btnRoll = new Button("Roll");
        dicePane.add(btnRoll, 3, 2);

        lblRolled = new Label("Rolled: " + dice.getThrowCount());
        dicePane.add(lblRolled, 4, 2);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields

        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        // TODO
        txfResults = new TextField[dice.getResults().length];

        for (int i = 0; i < dice.getResults().length; i++) {
            TextField textField = new TextField();
            txfResults[i] = textField;
            txfResults[i].setText(String.valueOf(dice.getResults()[i]));
            scorePane.add(txfResults[i], 1, i);
            txfResults[i].setEditable(false);
            txfResults[i].setPrefWidth(w);
            txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event));
        }

        lblResults = new Label[]{new Label("1s"), new Label("2s"), new Label("3s"), new Label("4s"),
                new Label("5s"), new Label("6s"), new Label("One Pair"), new Label("Two Pair"),
                new Label("Three same"), new Label("Four same"), new Label("Full house"),
                new Label("Small straight"), new Label("Large straight"), new Label("Chance"), new Label("Yatzy")};
        for (int i = 0; i < dice.getResults().length; i++) {
            scorePane.add(lblResults[i], 0, i);
        }

        lblSumSame = new Label("Sum:");
        scorePane.add(lblSumSame, 2, 5);

        txfSumSame = new TextField("0");
        scorePane.add(txfSumSame, 3, 5);
        txfSumSame.setPrefWidth(w);
        txfSumSame.setEditable(false);

        lblBonus = new Label("Bonus:");
        scorePane.add(lblBonus, 4, 5);

        txfBonus = new TextField("0");
        scorePane.add(txfBonus, 5, 5);
        txfBonus.setPrefWidth(w);
        txfBonus.setEditable(false);

        lblSumOther = new Label("Sum:");
        scorePane.add(lblSumOther, 2, 14);

        txfSumOther = new TextField("0");
        scorePane.add(txfSumOther, 3, 14);
        txfSumOther.setPrefWidth(w);
        txfSumOther.setEditable(false);

        lblTotal = new Label("Total:");
        scorePane.add(lblTotal, 4, 14);

        txfTotal = new TextField("0");
        scorePane.add(txfTotal, 5, 14);
        txfTotal.setPrefWidth(w);
        txfTotal.setEditable(false);

        btnRoll.setOnAction(event -> rollAction());

    }

    // -------------------------------------------------------------------------

    // Create a method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO
    private void rollAction() {
        holds = new boolean[5];
        for (int i = 0; i < holds.length; i++) {
            holds[i] = chbHolds[i].isSelected();
        }
        dice.throwDice(holds);
        updateValues();
        updateResults();
        updateSumSame();
        updateSumOther();
        updateTotal();
        checkBonus();
		lblRolled.setText("Rolled: " + dice.getThrowCount());
        if (dice.getThrowCount()==3) {
            btnRoll.setDisable(true);
        }
    }

    private void updateValues() {
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(String.valueOf(dice.getValues()[i]));
        }
    }

    private void updateResults() {
        for (int i = 0; i < txfResults.length; i++) {
            if (!txfResults[i].isDisabled()) {
                txfResults[i].setText(String.valueOf(dice.getResults()[i]));
            }
        }
    }
    
    private void updateSumSame(){
        int holder = 0;
        for (int i = 0; i < 6; i++) {
            if (txfResults[i].isDisabled()){
                holder += Integer.parseInt(txfResults[i].getText());
            }
        }
        txfSumSame.setText(String.valueOf(holder));
    }
    private void updateSumOther(){
        int holder = 0;
        for (int i = 6; i < txfResults.length; i++) {
            if (txfResults[i].isDisabled()){
                holder += Integer.parseInt(txfResults[i].getText());
            }
        }
        txfSumOther.setText(String.valueOf(holder));
    }

    private void checkBonus(){
        int bonus = Integer.parseInt(txfSumSame.getText());
        if (bonus >= 63){
            txfBonus.setText("50");
        }
    }
    private void updateTotal() {
        int sumSame = Integer.parseInt(txfSumSame.getText());
        int sumOther = Integer.parseInt(txfSumOther.getText());
        int bonus = Integer.parseInt(txfBonus.getText());
        int total = sumOther + sumSame + bonus;
        txfTotal.setText(String.valueOf(total));
    }
    private void resetChbHolds() {
        for (int i = 0; i < chbHolds.length; i++) {
            chbHolds[i].setSelected(false);
        }
    }
    
    public void chooseFieldAction(Event event) {
        TextField txt = (TextField) event.getSource();

        txt.setDisable(true);

        reset();
    }

    private void reset() {
        int[] values1 = {0, 0, 0, 0, 0};
        dice.setValues(values1);
        dice.resetThrowCount();
        lblRolled.setText("Rolled: " + dice.getThrowCount());
        resetChbHolds();
        rollAction();
        btnRoll.setDisable(false);
    }


        // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO

}
