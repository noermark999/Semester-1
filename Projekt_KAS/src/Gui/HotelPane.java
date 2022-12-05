package Gui;

import Application.Controller.KASController;
import Application.Model.Hotel;
import Application.Model.Service;
import Application.Model.Tilmelding;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class HotelPane extends GridPane {
    private TextField txfName, txfpris1, txfAdr, txfpris2;
    private ListView<Hotel> lvwHotel;
    private TextArea txaService, txaTilmelding;

    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblHotel = new Label("Hoteller");
        this.add(lblHotel, 0, 0);

        lvwHotel = new ListView<>();
        this.add(lvwHotel, 0, 1, 1, 5);
        lvwHotel.setPrefWidth(200);
        lvwHotel.setPrefHeight(200);
        lvwHotel.getItems().setAll(KASController.getHotels());
        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
        lvwHotel.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setPrefWidth(200);
        txfName.setEditable(false);

        Label lblpris1 = new Label("Pris enkelt");
        this.add(lblpris1, 1, 2);

        txfpris1 = new TextField();
        this.add(txfpris1, 2, 2);
        txfpris1.setEditable(false);

        Label lblpris2 = new Label("Pris dobbelt");
        this.add(lblpris2, 1, 3);

        txfpris2 = new TextField();
        this.add(txfpris2, 2, 3);
        txfpris2.setEditable(false);
        
        Label lblAdr = new Label("Adresse:");
        this.add(lblAdr, 1, 4);

        txfAdr = new TextField();
        this.add(txfAdr, 2, 4);
        txfAdr.setEditable(false);

        Label lblService = new Label("Services:");
        this.add(lblService, 1, 5);
        GridPane.setValignment(lblService, VPos.BASELINE);
        lblService.setPadding(new Insets(4, 0, 4, 0));

        txaService = new TextArea();
        this.add(txaService, 2, 5);
        txaService.setPrefWidth(200);
        txaService.setPrefHeight(100);
        txaService.setEditable(false);

        Label lblTilmeldning = new Label("Tilmeldninger:");
        this.add(lblTilmeldning, 1, 6);
        GridPane.setValignment(lblTilmeldning, VPos.BASELINE);
        lblTilmeldning.setPadding(new Insets(4, 0, 4, 0));

        txaTilmelding = new TextArea();
        this.add(txaTilmelding, 2, 6);
        txaTilmelding.setPrefWidth(200);
        txaTilmelding.setPrefHeight(100);
        txaTilmelding.setEditable(false);

        HBox hbxButtons = new HBox(10);
        this.add(hbxButtons, 0, 7, 1, 1);
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

        Button btnService = new Button("Create Service");
        hbxButtons.getChildren().add(btnService);
        btnService.setOnAction(event -> this.serviceAction());

        Alert alert = new Alert(AlertType.CONFIRMATION);

        Button btnClose = new Button("Close");
        hbxButtons.getChildren().add(btnClose);
        btnClose.setOnAction(event -> this.closeAction());


        if (lvwHotel.getItems().size() > 0) {
            lvwHotel.getSelectionModel().select(0);
        }
    }

    // -------------------------------------------------------------------------

    private void createAction() {
        HotelWindow dia = new HotelWindow("Create Hotel");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwHotel.getItems().setAll(KASController.getHotels());
        this.updateControls();
    }

    private void updateAction() {

         Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
         if (hotel != null) {
            HotelWindow dia = new HotelWindow("Update Deltager", hotel);
            dia.showAndWait();

            // Wait for the modal dialog to close

            int selectIndex = lvwHotel.getSelectionModel().getSelectedIndex();
            lvwHotel.getItems().setAll(KASController.getHotels());
            lvwHotel.getSelectionModel().select(selectIndex);
        }
    }

    private void deleteAction() {
        Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Slet hotel");
            alert.setContentText("Er du sikker?");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();

            // Wait for the modal dialog to close

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                KASController.deleteHotel(hotel);
                lvwHotel.getItems().setAll(KASController.getHotels());
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

    private void serviceAction() {
        Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
        if (hotel != null) {

            ServiceWindow dia = new ServiceWindow("Create Service", hotel);
            dia.showAndWait();

            // Wait for the modal dialog to close

            int selectIndex = lvwHotel.getSelectionModel().getSelectedIndex();
            lvwHotel.getSelectionModel().select(selectIndex);
        }
        this.updateControls();
    }


    // -------------------------------------------------------------------------

    private void selectedHotelChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            txfName.setText(hotel.getNavn());
            txfpris1.setText(String.valueOf(hotel.getPrisEnkelt()));
            txfpris2.setText(String.valueOf(hotel.getPrisDobbelt()));
            txfAdr.setText(hotel.getAdresse());
            StringBuilder sb = new StringBuilder();
            for (Service service : hotel.getServices()) {
                sb.append(service.getNavn() + "(" +service.getPris() + "kr. )" + "\n");
            }
            txaService.setText(sb.toString());
            StringBuilder sb1 = new StringBuilder();
            for (Tilmelding tilmelding : hotel.getTilmeldinger()) {
                if (tilmelding.getLedsagerNavn() != null) {
                    sb1.append(tilmelding.getDeltager() + " (2 værelses)" + "\n");
                }else {
                   sb1.append(tilmelding.getDeltager() + "\n");
                }
            }
            txaTilmelding.setText(sb1.toString());
        } else {
            txfName.clear();
            txfpris1.clear();
            txfpris2.clear();
            txfAdr.clear();
            txaService.clear();
            txaTilmelding.clear();
        }
    }
}
