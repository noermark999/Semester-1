package Gui;

import Application.Controller.KASController;
import Application.Model.Hotel;
import Application.Model.Konference;
import Application.Model.Udflugt;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AddUdflugtWindow extends Stage {
    private Konference konference;

    public AddUdflugtWindow(String title, Konference konference) {

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

    private ComboBox<Udflugt> cbbUd;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Vælg Udflugt");
        pane.add(lblName, 0, 0);

        cbbUd = new ComboBox<>();
        pane.add(cbbUd, 0, 1);
        cbbUd.getItems().addAll(KASController.getUdlfugterKonfDato(konference));


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
        Udflugt udflugt = cbbUd.getSelectionModel().getSelectedItem();
        if (udflugt == null) {
            lblError.setText("Vælg en udflugt");
        }  else if (konference.getUdflugter().contains(udflugt)) {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Error");
            dialog.setHeaderText("Udflugt er allerede tilknyttet konferencen");
            dialog.showAndWait();
        } else {
            KASController.addUdflugtTilKonference(udflugt,konference);
            hide();
        }
    }
}
