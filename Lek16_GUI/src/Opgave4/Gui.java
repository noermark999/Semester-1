package Opgave4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> boyNames = new ArrayList<>();
    private final TextField txfName = new TextField();
    protected void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 0);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 6);

        pane.add(txfName, 1, 6, 2, 1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwNames, 1, 0, 1, 5);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(boyNames);

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwNames.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 3, 6);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }


    private void addAction() {
        if (!txfName.getText().isEmpty()){
            boyNames.add(txfName.getText());
            lvwNames.getItems().setAll(boyNames);
            txfName.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add name");
            alert.setHeaderText("No named typed");
            alert.setContentText("Type the name of the person");
            alert.show();
        }
    }
    private void selectionChanged() {
        String newName = lvwNames.getSelectionModel().getSelectedItem();
        if (newName != null) {
            txfName.setText(newName);
        } else {
            txfName.clear();
        }
    }
}

