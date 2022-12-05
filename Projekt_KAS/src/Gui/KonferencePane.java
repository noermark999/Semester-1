package Gui;

import Application.Controller.KASController;
import Application.Model.Hotel;
import Application.Model.Konference;
import Application.Model.Tilmelding;

import Application.Model.Udflugt;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.beans.value.ChangeListener;
import javafx.scene.layout.Region;

import java.util.Optional;

public class KonferencePane extends GridPane {
    private TextField txfName, txfAdresse, txfPris, txfStDate, txfSlDate;
    private TextArea txaKonf, txaDel, txaHot, txaUd;
    private ListView<Konference> lvwKonference;

    private Button addHot, addUd;


    public KonferencePane() {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblComp = new Label("Konferencer");
        this.add(lblComp, 0, 0);

        lvwKonference = new ListView<>();
        this.add(lvwKonference, 0, 1, 1, 4);
        lvwKonference.setPrefWidth(200);
        lvwKonference.setPrefHeight(200);
        lvwKonference.getItems().setAll(KASController.getKonferencer());
        ChangeListener<Konference> listener = (ov, oldCompny, newCompany) -> this.selectedKonferenceChanged();
        lvwKonference.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblName = new Label("Navn:");
        this.add(lblName, 1, 1);


        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setEditable(false);

        Label lblAdresse = new Label("Adresse:");
        this.add(lblAdresse, 1, 2);

        txfAdresse = new TextField();
        this.add(txfAdresse, 2, 2);
        txfAdresse.setEditable(false);

        Label lblPris = new Label("Dagspris");
        this.add(lblPris,1,3);

        txfPris = new TextField();
        this.add(txfPris,2,3);
        txfPris.setEditable(false);


        Label lblStDate = new Label("Start Dato:");
        this.add(lblStDate,1,5);

        txfStDate = new TextField();
        this.add(txfStDate,2,5);
        txfStDate.setEditable(false);

        Label lblSlDate = new Label("Slut Dato:");
        this.add(lblSlDate,1,6);

        txfSlDate = new TextField();
        this.add(txfSlDate,2,6);
        txfStDate.setEditable(false);

        Label lblDel = new Label("Deltagere");
        this.add(lblDel, 1, 4);

        txaDel = new TextArea();
        this.add(txaDel, 2, 4);
        txaDel.setEditable(false);
        txaDel.setMaxWidth(300);

        Label lblHot = new Label("Hoteller");
        this.add(lblHot,1,7);

        txaHot = new TextArea();
        this.add(txaHot,2,7);
        txaHot.maxHeight(100);
        txaHot.setPrefRowCount(3);
        txaHot.setPrefColumnCount(1);

        Label lblUd = new Label("Udflugt");
        this.add(lblUd,1,8);

        txaUd = new TextArea();
        this.add(txaUd,2,8);
        txaUd.setPrefRowCount(3);
        txaUd.setMaxWidth(300);

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

        Button btnClose = new Button("Close");
        hbxButtons.getChildren().add(btnClose);
        btnClose.setOnAction(event -> this.closeAction());

        Button tilmeld = new Button("Tilmeld Konference");
        this.add(tilmeld,0,5);
        tilmeld.setOnAction(event -> this.tilmeldAction());

        HBox hbxButtons1 = new HBox(10);
        this.add(hbxButtons1, 0, 7, 1, 1);
        hbxButtons1.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons1.setAlignment(Pos.BASELINE_CENTER);

        addHot = new Button("Tilføj nyt hotel");
        hbxButtons1.getChildren().add(addHot);
        addHot.setOnAction(event -> this.addHotelAction());

        addUd = new Button("Tilføj ny Udflugt");
        hbxButtons1.getChildren().add(addUd);
        addUd.setOnAction(event -> this.addUdflugtAction());


        if (lvwKonference.getItems().size() > 0) {
            lvwKonference.getSelectionModel().select(0);
        }
    }

    private void addHotelAction() {
        Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
        AddHotelWindow dia = new AddHotelWindow("tilknyt hotel til konference", konference);
        dia.showAndWait();
        updateControls();
    }

    private void addUdflugtAction() {
        Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
        AddUdflugtWindow dia = new AddUdflugtWindow("Tilknyt udflugt til konference",konference);
        dia.showAndWait();
        updateControls();
    }

    // -------------------------------------------------------------------------


        private void createAction () {
            KonferenceWindow dia = new KonferenceWindow("Create Konference");
            dia.showAndWait();

            // Wait for the modal dialog to close

            lvwKonference.getItems().setAll(KASController.getKonferencer());
            int index = lvwKonference.getItems().size() - 1;
            lvwKonference.getSelectionModel().select(index);
        }


        private void updateAction () {
            Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
            if (konference != null) {

                KonferenceWindow dia = new KonferenceWindow("Update Konference", konference);
                dia.showAndWait();

                // Wait for the modal dialog to close

                int selectIndex = lvwKonference.getSelectionModel().getSelectedIndex();
                lvwKonference.getItems().setAll(KASController.getKonferencer());
                lvwKonference.getSelectionModel().select(selectIndex);
            }
        }


        private void deleteAction () {
            Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
            if (konference != null) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Slet Konference");
                    // alert.setContentText("Are you sure?");
                    alert.setHeaderText("Er du sikker?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                        KASController.deleteKonference(konference);
                        lvwKonference.getItems().setAll(KASController.getKonferencer());
                        this.updateControls();
                    }
            }

        }

        private void closeAction () {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Luk programmet");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();
            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                Platform.exit();
            }
        }
        private void tilmeldAction() {
            Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
            if (konference != null) {

                TilmeldningsWindow dia = new TilmeldningsWindow("Tilmeld", konference);
                dia.showAndWait();

                // Wait for the modal dialog to close

                int selectIndex = lvwKonference.getSelectionModel().getSelectedIndex();
                lvwKonference.getItems().setAll(KASController.getKonferencer());
                lvwKonference.getSelectionModel().select(selectIndex);
                updateControls();
            }
        }

        // -------------------------------------------------------------------------

        private void selectedKonferenceChanged() {
        this.updateControls();
        }

        public void updateControls () {
            Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
            if (konference != null) {
                String pris = String.valueOf(konference.getPris());
                txfName.setText(konference.getNavn());
                txfAdresse.setText(konference.getAdresse());
                txfPris.setText(pris);
                txfStDate.setText(konference.getStartDato().toString());
                txfSlDate.setText(konference.getSlutDato().toString());
                StringBuilder sb = new StringBuilder();
                StringBuilder hs = new StringBuilder();
                StringBuilder us = new StringBuilder();
                for (Tilmelding til : konference.getTilmeldings()) {
                    sb.append(til + "\n");
                }
                for(Hotel til : konference.getHotels()) {
                    hs.append(til + "\n");
                }
                for(Udflugt til : konference.getUdflugter()){
                    us.append(til + "\n");
                }
                txaUd.setText(us.toString());
                txaHot.setText(hs.toString());
                txaDel.setText(sb.toString());

            } else {
                txfName.clear();
                txfAdresse.clear();
                txfPris.clear();
                txfStDate.clear();
                txfSlDate.clear();
                txaUd.clear();
                txaHot.clear();
                txaDel.clear();
            }
        }
    }
