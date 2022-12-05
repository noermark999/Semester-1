package Gui;

import Application.Controller.KASController;
import Application.Model.Hotel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ServiceWindow extends Stage {
    private Hotel hotel;

    public ServiceWindow(String title, Hotel hotel) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.hotel = hotel;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public ServiceWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private TextField txfnavn, txfPris;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Service navn");
        pane.add(lblName, 0, 0);

        txfnavn = new TextField();
        pane.add(txfnavn, 0, 1);
        txfnavn.setPrefWidth(200);

        Label lblPris = new Label("Service Pris");
        pane.add(lblPris, 0, 2);

        txfPris = new TextField();
        pane.add(txfPris, 0, 3);
        txfPris.setPrefWidth(200);

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

        initControls();
    }

    private void initControls() {
        txfnavn.clear();
        txfPris.clear();
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        String navn = txfnavn.getText().trim();
        if (navn.length() == 0 || txfPris.getText().length() == 0) {
            lblError.setText("Udfyld alle felter");
        } else {
            int pris = Integer.parseInt(txfPris.getText());
            KASController.createService(hotel,navn,pris);
            hide();
        }
    }

    // -------------------------------------------------------------------------

}
