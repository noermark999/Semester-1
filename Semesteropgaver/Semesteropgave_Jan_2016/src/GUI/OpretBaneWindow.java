package GUI;

import Application.Controller.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OpretBaneWindow extends Stage {

    public OpretBaneWindow(String title) {

        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }
    // -------------------------------------------------------------------------

    private Label lblError;

    private TextField txfNr;
    private TextField txfInfo;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblNr = new Label("Nummer:");
        pane.add(lblNr,0,0);

        txfNr = new TextField("");
        pane.add(txfNr,1,0);

        Label lblInfo = new Label("Info:");
        pane.add(lblInfo,0,1);

        txfInfo = new TextField("");
        pane.add(txfInfo,1,1);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 2);
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 2);
        GridPane.setHalignment(btnOK, HPos.LEFT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 3,2,1);
        lblError.setStyle("-fx-text-fill: red");
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        if (txfNr.getText().length() == 0) {
            lblError.setText("Skriv et nummer");
        } else if (txfInfo.getText().length() == 0) {
            lblError.setText("Skriv info");
        } else {
            Service.createBane(Integer.parseInt(txfNr.getText()),txfInfo.getText());
            hide();
        }
    }
}
