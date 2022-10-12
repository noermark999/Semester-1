package Opgave1;

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

    // -------------------------------------------------------------------------

    private final ListView<Opgave1.Person> lvwPersons = new ListView<>();
    private final ArrayList<Opgave1.Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox chkSenior = new CheckBox();

    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 3);

        pane.add(txfName, 1, 0, 2, 1);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle,0,1);

        pane.add(txfTitle,1,1,2,1);

        Label lblActive = new Label("Senior:");
        pane.add(lblActive,0,2);

        pane.add(chkSenior,1,2);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add person");
        pane.add(btnAdd, 6, 0);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        if (name.length() > 0 && title.length() > 0) {
            Opgave1.Person p = new Opgave1.Person(name,title,chkSenior.isSelected());
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
            clearBoxes();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add person");
            alert.setHeaderText("No named or title typed");
            alert.setContentText("Type the name and title of the person");
            alert.show();
        }
    }

    private void clearBoxes() {
        txfName.clear();
        txfTitle.clear();
        chkSenior.setSelected(false);
    }

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
        } else {
            txfName.clear();
        }
    }
}
