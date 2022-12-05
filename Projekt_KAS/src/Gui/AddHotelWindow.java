package Gui;

import Application.Controller.KASController;
import Application.Model.Hotel;
import Application.Model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AddHotelWindow extends Stage {
    private Konference konference;

    public AddHotelWindow(String title, Konference konference) {

        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.konference = konference;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }
    // -------------------------------------------------------------------------

    private Label lblError;

    private ComboBox<Hotel> cbbHotel;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Vælg Hotel");
        pane.add(lblName, 0, 0);

        cbbHotel = new ComboBox<>();
        pane.add(cbbHotel, 0, 1);
        cbbHotel.getItems().addAll(KASController.getHotels());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.LEFT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        Hotel hotel = cbbHotel.getSelectionModel().getSelectedItem();
        if (hotel == null) {
            lblError.setText("Vælg et hotel");
        } else if (konference.getHotels().contains(hotel)) {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Error");
            dialog.setHeaderText("Hotel er allerede tilknyttet konferencen");
            dialog.showAndWait();
        }else {
            KASController.addHotelTilKonference(hotel,konference);
            hide();
        }
    }
}
