package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConverterGui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Swap Frame");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        paneContent(pane);
        stage.setScene(scene);
        stage.show();
    }
    private final TextField celsiusBox = new TextField();
    private final TextField fahrenheitBox = new TextField();
    private final TextField combined = new TextField();
    private void paneContent(GridPane pane) {

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label c = new Label("Celsius: ");
        pane.add(c,0,0);
        pane.add(celsiusBox,1, 0);

        Label f = new Label("Fahrenheit: ");
        pane.add(f,0,1);
        pane.add(fahrenheitBox,1,1);

        Button btnConvert = new Button("Convert");
        pane.add(btnConvert,1,3);

        btnConvert.setOnAction(event -> convert());
    }

    private void convert() {
        if (!celsiusBox.getText().isEmpty()){
            double celsius = Double.parseDouble(celsiusBox.getText());
            double fahrenheit = 9.0/5.0*celsius+32;
            fahrenheitBox.setText(String.valueOf(fahrenheit));
        } else if (!fahrenheitBox.getText().isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitBox.getText());
            double celsius = (fahrenheit-32)*5.0/9.0;
            celsiusBox.setText(String.valueOf(celsius));
        }

    }
}
