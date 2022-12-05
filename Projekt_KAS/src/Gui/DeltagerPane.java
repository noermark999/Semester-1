package Gui;

import Application.Controller.KASController;
import Application.Model.Deltager;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class DeltagerPane extends GridPane {
    private TextField txfName, txfNr, txfAdr, txfByLand, txfFirma, txfFirmaTlf;
    private ListView<Deltager> lvwDeltager;

    public DeltagerPane() {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblComp = new Label("Deltager");
        this.add(lblComp, 0, 0);

        lvwDeltager = new ListView<>();
        this.add(lvwDeltager, 0, 1, 1, 5);
        lvwDeltager.setPrefWidth(200);
        lvwDeltager.setPrefHeight(200);
        lvwDeltager.getItems().setAll(KASController.getDeltager());
        ChangeListener<Deltager> listener = (ov, oldEmployee, newEmployee) -> this.selectedEmployeeChanged();
        lvwDeltager.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setPrefWidth(200);
        txfName.setEditable(false);

        Label lblNr = new Label("Telefon nr:");
        this.add(lblNr, 1, 2);

        txfNr = new TextField();
        this.add(txfNr, 2, 2);
        txfNr.setEditable(false);

        Label lblAdr = new Label("Adresse:");
        this.add(lblAdr, 1, 3);

        txfAdr = new TextField();
        this.add(txfAdr, 2, 3);
        txfAdr.setEditable(false);

        Label lblByLand = new Label("By/Land");
        this.add(lblByLand, 1, 4);

        txfByLand = new TextField();
        this.add(txfByLand, 2, 4);
        txfByLand.setEditable(false);

        Label lblFirma = new Label("Firma");
        this.add(lblFirma, 1, 5);

        txfFirma = new TextField();
        this.add(txfFirma, 2, 5);
        txfFirma.setEditable(false);

        Label lblFirmaTlf = new Label("Firma telefon nr.");
        this.add(lblFirmaTlf, 1, 6);

        txfFirmaTlf = new TextField();
        this.add(txfFirmaTlf, 2, 6);
        txfFirmaTlf.setEditable(false);


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


        if (lvwDeltager.getItems().size() > 0) {
            lvwDeltager.getSelectionModel().select(0);
        }
    }

    // -------------------------------------------------------------------------

    private void createAction() {
        DeltagerWindow dia = new DeltagerWindow("Create Deltager");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwDeltager.getItems().setAll(KASController.getDeltager());
        this.updateControls();
    }

    private void updateAction() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();
        if (deltager != null) {

            DeltagerWindow dia = new DeltagerWindow("Update Deltager", deltager);
            dia.showAndWait();

            // Wait for the modal dialog to close

            int selectIndex = lvwDeltager.getSelectionModel().getSelectedIndex();
            lvwDeltager.getItems().setAll(KASController.getDeltager());
            lvwDeltager.getSelectionModel().select(selectIndex);
        }
    }

    private void deleteAction() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();
        if (deltager != null) {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Slet deltager");
            // alert.setContentText("Are you sure?");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();

            // Wait for the modal dialog to close

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                KASController.deleteDeltager(deltager);
                lvwDeltager.getItems().setAll(KASController.getDeltager());
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

    private void selectedEmployeeChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            txfName.setText(deltager.getNavn());
            txfNr.setText(deltager.getTlf());
            txfAdr.setText(deltager.getAdresse());
            txfByLand.setText(deltager.getByLand());

            txfFirma.setText(deltager.getFirmaNavn());
            txfFirmaTlf.setText(deltager.getFirmaTlf());
        } else {
            txfName.clear();
            txfNr.clear();
            txfAdr.clear();
            txfByLand.clear();
            txfFirma.clear();
            txfFirmaTlf.clear();
        }
    }
}
