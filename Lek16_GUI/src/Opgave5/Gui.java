package Opgave5;

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
    private final ArrayList<String> girlNames = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final ToggleGroup group = new ToggleGroup();
    private boolean isBoys = true;
    private final RadioButton boys = new RadioButton("Boy");
    private final RadioButton girls = new RadioButton("Girl");

    protected void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(boys, 0, 0);
        boys.setToggleGroup(group);
        boys.setOnAction(event -> boysList());

        pane.add(girls, 1, 0);
        girls.setToggleGroup(group);
        girls.setOnAction(event -> girlsList());

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 7);

        pane.add(txfName, 1, 7, 2, 1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwNames, 1, 1, 1, 5);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwNames.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 3, 7);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }


    private void addAction() {
        if (boys.isSelected() || girls.isSelected()) {
            if (!txfName.getText().isEmpty()) {
                if (isBoys) {
                    boyNames.add(txfName.getText());
                    lvwNames.getItems().setAll(boyNames);
                    txfName.clear();
                } else {
                    girlNames.add(txfName.getText());
                    lvwNames.getItems().setAll(girlNames);
                    txfName.clear();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Add name");
                alert.setHeaderText("No named typed");
                alert.setContentText("Type the name of the person");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Select boys or girls");
            alert.setHeaderText("No sex selected");
            alert.setContentText("Select the sex of the person");
            alert.show();
        }
    }

    private void boysList() {
        lvwNames.getItems().setAll(boyNames);
        isBoys = true;
    }

    private void girlsList() {
        lvwNames.getItems().setAll(girlNames);
        isBoys = false;
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

