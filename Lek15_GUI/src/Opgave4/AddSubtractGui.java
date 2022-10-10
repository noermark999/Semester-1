package Opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddSubtractGui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Tæl op");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        paneContent(pane);
        stage.setScene(scene);
        stage.show();
    }
    private final TextField numberBox = new TextField();
    private final TextField combined = new TextField();
    private int number = 50;
    private void paneContent(GridPane pane) {

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label numberText = new Label("Number: ");
        pane.add(numberText,0,1);

        numberBox.setText(String.valueOf(number));
        pane.add(numberBox,1, 1);

        Button btnAdd = new Button("+");
        pane.add(btnAdd,2,0);

        Button btnMinus = new Button("-");
        pane.add(btnMinus,2,2);

        btnAdd.setOnAction(event -> add());
        btnMinus.setOnAction(event -> minus());
    }

    private void add() {
        number = Integer.parseInt(numberBox.getText());
        number++;
        numberBox.setText(String.valueOf(number));
    }
    private void minus() {
        number = Integer.parseInt(numberBox.getText());
        number--;
        numberBox.setText(String.valueOf(number));
    }
}
