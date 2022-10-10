package Opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SwapGui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Swap Frame");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        paneContent(pane);
        stage.setScene(scene);
        stage.show();
    }
    private final TextField firstWord = new TextField();
    private final TextField secondWord = new TextField();
    private final TextField combined = new TextField();
    private void paneContent(GridPane pane) {

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(firstWord,1, 0);

        pane.add(secondWord,1,1);

        Button btnSwap = new Button("Swap");
        pane.add(btnSwap,1,3);

        btnSwap.setOnAction(event -> swap());
    }

    private void swap() {
        String placeholder = firstWord.getText();
        firstWord.setText(secondWord.getText());
        secondWord.setText(placeholder);
    }
}
