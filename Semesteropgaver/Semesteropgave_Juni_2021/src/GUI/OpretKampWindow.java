package GUI;

import Application.Controller.Controller;
import Application.Model.Kamp;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalTime;

public class OpretKampWindow extends Stage {

    private Kamp kamp;

    public OpretKampWindow(String title, Kamp kamp) {

        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.kamp = kamp;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public OpretKampWindow(String title) {
        this(title, null);
    }
    // -------------------------------------------------------------------------

    private Label lblError;

    private TextField txfSted, txfTime, txfMinut;

    private DatePicker dpDato;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblSted = new Label("Spillested:");
        pane.add(lblSted,0,0);

        txfSted = new TextField();
        pane.add(txfSted,1,0);

        Label lblDato = new Label("Spillesdato:");
        pane.add(lblDato,0,1);

        dpDato = new DatePicker();
        pane.add(dpDato,1,1);

        Label lblTid = new Label("Spilletid time:");
        pane.add(lblTid,0,2);

        txfTime = new TextField();
        pane.add(txfTime,1,2);

        Label lblMinut = new Label("Spilletid minut:");
        pane.add(lblMinut,0,3);

        txfMinut = new TextField();
        pane.add(txfMinut,1,3);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 4);
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 4);
        GridPane.setHalignment(btnOK, HPos.LEFT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 5,2,1);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    // -------------------------------------------------------------------------

    private void initControls() {
        if (kamp != null) {
            txfSted.setText(kamp.getSted());
            dpDato.setValue(kamp.getDato());
            txfTime.setText(String.valueOf(kamp.getTid().getHour()));
            txfMinut.setText(String.valueOf(kamp.getTid().getMinute()));
        } else {
            txfTime.clear();
            txfSted.clear();
            txfMinut.clear();
            dpDato.setValue(null);
        }
    }

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        if (txfSted.getText().length() == 0) {
            lblError.setText("Skriv et sted");
        } else if (dpDato.getValue() == null) {
            lblError.setText("Skriv dato");
        } else if (txfTime.getText().length() == 0 || txfMinut.getText().length() == 0){
            lblError.setText("Skriv et tidspunkt");
        } else {
            Controller.createKamp(txfSted.getText(),dpDato.getValue(), LocalTime.of(Integer.parseInt(txfTime.getText()),Integer.parseInt(txfMinut.getText())));
            hide();
        }
    }
}
