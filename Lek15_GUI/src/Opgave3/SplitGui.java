package Opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SplitGui extends Application {

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

        firstName.setEditable(false);
        pane.add(firstName,0, 1);

        lastName.setEditable(false);
        pane.add(lastName,1,1);

        pane.add(combined,0,0,2,1);

        Button btnCombine = new Button("Split");
        pane.add(btnCombine,0,3);

        btnCombine.setOnAction(event -> split());
    }

    private void split() {
        String name = combined.getText();
        String[] names;
        names = name.split(" ");
        firstName.setText(names[0]);
        lastName.setText(names[1]);
    }
}
