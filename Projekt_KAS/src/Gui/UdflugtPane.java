package Gui;

import Application.Controller.KASController;
import Application.Model.Udflugt;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class UdflugtPane extends GridPane {
    private TextField txfName, txfPris, txfFrokost, txfDato;
    private ListView<Udflugt> lvwUdflugt;
    private CheckBox cbFrokost;

    public UdflugtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblComp = new Label("Udflugter");
        this.add(lblComp, 0, 0);

        lvwUdflugt = new ListView<>();
        this.add(lvwUdflugt, 0, 1, 1, 5);
        lvwUdflugt.setPrefWidth(200);
        lvwUdflugt.setPrefHeight(200);
        lvwUdflugt.getItems().setAll(KASController.getUdflugter());
        ChangeListener<Udflugt> listener = (ov, oldEmployee, newEmployee) -> this.selectedUdflugter();
        lvwUdflugt.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setPrefWidth(200);
        txfName.setEditable(false);

        Label lblNr = new Label("Pris:");
        this.add(lblNr, 1, 2);

        txfPris = new TextField();
        this.add(txfPris, 2, 2);
        txfPris.setEditable(false);

        Label lblAdr = new Label("Frokost:");
        this.add(lblAdr, 1, 3);

        cbFrokost = new CheckBox();
        this.add(cbFrokost, 2, 3);
        cbFrokost.setDisable(true);

        Label lblBy = new Label("Dato");
        this.add(lblBy, 1, 4);

        txfDato = new TextField();
        this.add(txfDato, 2, 4);
        txfDato.setEditable(false);


        HBox hbxButtons = new HBox(10);
        this.add(hbxButtons, 0, 6, 1, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());

        Alert alert = new Alert(AlertType.CONFIRMATION);

        Button btnClose = new Button("Close");
        hbxButtons.getChildren().add(btnClose);
        btnClose.setOnAction(event -> this.closeAction());


        if (lvwUdflugt.getItems().size() > 0) {
            lvwUdflugt.getSelectionModel().select(0);
        }
    }

    // -------------------------------------------------------------------------

    private void createAction() {
        UdflugtWindow dia = new UdflugtWindow("Create Udflugt");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwUdflugt.getItems().setAll(KASController.getUdflugter());
        this.updateControls();
    }

    private void updateAction() {
        Udflugt udflugt = lvwUdflugt.getSelectionModel().getSelectedItem();
        if (udflugt != null) {

            UdflugtWindow dia = new UdflugtWindow("Update Udflugt", udflugt);
            dia.showAndWait();

            // Wait for the modal dialog to close

            int selectIndex = lvwUdflugt.getSelectionModel().getSelectedIndex();
            lvwUdflugt.getItems().setAll(KASController.getUdflugter());
            lvwUdflugt.getSelectionModel().select(selectIndex);
        }
    }

    private void deleteAction() {
        Udflugt udflugt = lvwUdflugt.getSelectionModel().getSelectedItem();
        if (udflugt != null) {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Slet udflugt");
            // alert.setContentText("Are you sure?");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();

            // Wait for the modal dialog to close

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                KASController.deleteUdflugt(udflugt);
                lvwUdflugt.getItems().setAll(KASController.getUdflugter());
                this.updateControls();
            }
        }

    }

    private void closeAction() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Luk programmet");
        alert.setHeaderText("Er du sikker?");
        Optional<ButtonType> result = alert.showAndWait();
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Platform.exit();
        }
    }


    // -------------------------------------------------------------------------

    private void selectedUdflugter() {
        this.updateControls();
    }

    public void updateControls() {
        Udflugt udflugt = lvwUdflugt.getSelectionModel().getSelectedItem();
        if (udflugt != null) {
            txfName.setText(udflugt.getNavn());
            txfDato.setText(udflugt.getDato().toString());
            txfPris.setText(String.valueOf(udflugt.getPris()));
            cbFrokost.setSelected(udflugt.getFrokost());
        } else {
            txfName.clear();
            txfPris.clear();
            txfDato.clear();
            cbFrokost.setSelected(false);
        }
    }

}
