package Gui;

import Application.Controller.KASController;
import Application.Model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;


public class KonferenceWindow extends Stage {
    private Konference konference;

    public KonferenceWindow(String title, Konference konference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        this.setHeight(260);
    }

    public KonferenceWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private TextField txfName, txfAdresse, txfPris;

    private DatePicker dateStart, dateEnd;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 1, 0);
        txfName.setPrefWidth(200);

        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 1);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 1, 1);

        Label lblPris = new Label("Dags pris");
        pane.add(lblPris, 0, 2);

        txfPris = new TextField();
        pane.add(txfPris, 1, 2);

        Label lblStartDate = new Label("Start dato");
        pane.add(lblStartDate, 0, 3);

        dateStart = new DatePicker();
        pane.add(dateStart, 1, 3);
        dateStart.setEditable(false);

        Label lblEndDate = new Label("Slut dato");
        pane.add(lblEndDate, 0, 4);

        dateEnd = new DatePicker();
        pane.add(dateEnd, 1, 4);
        dateEnd.setEditable(false);

        Button btnCancel = new Button("OK");
        pane.add(btnCancel, 0, 5);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.okAction());

        Button btnOK = new Button("Cancel");
        pane.add(btnOK, 3, 5);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.cancelAction());

        this.initControls();
    }

    private void initControls() {
        if (konference != null) {
            txfName.setText(konference.getNavn());
            txfPris.setText(konference.getPris() + "");
            txfAdresse.setText(konference.getAdresse());
            dateStart.setValue(konference.getStartDato());
            dateEnd.setValue(konference.getSlutDato());
        } else {
            txfName.clear();
            txfPris.clear();
            txfAdresse.clear();
            dateStart.getEditor().clear();
            dateEnd.getEditor().clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }


    private void okAction() {
        String name = txfName.getText().trim();
        String adresse = txfAdresse.getText().trim();
        LocalDate localDate = dateStart.getValue();
        LocalDate localDate1 = dateEnd.getValue();
        if (name.length() > 0 && adresse.length() > 0 && txfPris.getText().length() > 0 && localDate.toString().length() != 0 && localDate1.toString().length() != 0) {
            int pris = Integer.parseInt(txfPris.getText());
            if (konference != null) {
                KASController.updateKonference(konference, name, adresse, pris, localDate, localDate1);
                hide();
            } else {
                KASController.createKonference(name, adresse, pris, localDate, localDate1);
                hide();
            }
        } else {
            Alert dialogFirma = new Alert(Alert.AlertType.INFORMATION);
            dialogFirma.setTitle("Error");
            dialogFirma.setHeaderText("Angiv noget i alle felter");
            dialogFirma.showAndWait();
        }
    }
}

