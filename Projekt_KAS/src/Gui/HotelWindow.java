package Gui;

import Application.Controller.KASController;
import Application.Model.Hotel;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelWindow extends Stage {
    private Hotel hotel;
    private TextField txfName;
    private TextField txfpris1;
    private TextField txfAdresse;
    private TextField txfpris2;
    private TextField txfFirmaNavn;
    private TextField txfFirmaTlf;
    private ComboBox cbKonference;

    public HotelWindow(String title, Hotel hotel) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.hotel = hotel;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    public HotelWindow(String title) {
        this(title, null);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Navn:");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);


        Label lblPris1 = new Label("Pris enkeltseng:");
        pane.add(lblPris1, 0, 2);

        txfpris1 = new TextField();
        pane.add(txfpris1, 0, 3);

        Label lblpris2 = new Label("Pris dobbeltseng:");
        pane.add(lblpris2, 0, 4);

        txfpris2 = new TextField();
        pane.add(txfpris2, 0, 5);

        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0, 6);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 0, 7);

        Button butOk = new Button("Ok");
        pane.add(butOk, 0, 8);
        butOk.setOnAction(actionEvent -> this.addOkAction());

        Button butCan = new Button("Cancel");
        pane.add(butCan, 3, 8);
        butCan.setOnAction(actionEvent -> hide());

        this.initControls();

    }

    private void initControls() {
        if (hotel != null) {
            txfName.setText(hotel.getNavn());
            txfpris1.setText(String.valueOf(hotel.getPrisEnkelt()));
            txfpris2.setText(String.valueOf(hotel.getPrisDobbelt()));
            txfAdresse.setText(hotel.getAdresse());
        } else {
            txfName.clear();
            txfpris1.clear();
            txfpris2.clear();
            txfAdresse.clear();
        }
    }

    private void addOkAction() {
        if (txfName.getText().length() > 0 || txfAdresse.getText().length() > 0 || txfpris2.getText().length() > 0 || txfpris1.getText().length() > 0) {
            String name = txfName.getText();
            int prisEnkelt = Integer.parseInt(txfpris1.getText());
            int prisDobbelt = Integer.parseInt(txfpris2.getText());
            String adresse = txfAdresse.getText();
            if (hotel != null) {
                KASController.updateHotel(hotel, name, prisEnkelt, prisDobbelt, adresse);
            } else {
                KASController.createHotel(name,prisEnkelt,prisDobbelt,adresse);
            }
            hide();
        } else {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Error");
            dialog.setHeaderText("Udfyld alle felter ");
            dialog.showAndWait();
        }
    }

}