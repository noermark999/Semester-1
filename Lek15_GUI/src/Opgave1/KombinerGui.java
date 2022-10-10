package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KombinerGui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Kombiner navne");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        paneContent(pane);
        stage.setScene(scene);
        stage.show();
    }
    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();
    private final TextField combined = new TextField();
    private void paneContent(GridPane pane) {

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(firstName,1, 0);

        pane.add(lastName,2,0);

        combined.setEditable(false);
        pane.add(combined,1,1,2,2);

        Button btnCombine = new Button("Kombiner");
        pane.add(btnCombine,1,4);

        btnCombine.setOnAction(event -> combine());
    }

    private void combine() {
        String name = firstName.getText() + " " + lastName.getText();
        combined.setText(name);
    }
}
