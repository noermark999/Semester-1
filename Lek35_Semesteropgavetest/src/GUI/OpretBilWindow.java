package GUI;

import Application.Controller.Controller;
import Application.Model.Bil;
import Application.Model.BilMærke;
import Application.Model.Parkeringshus;
import Application.Model.Parkeringsplads;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpretBilWindow extends Stage {
    private Parkeringshus parkeringshus;
    private String bilNr;

    public OpretBilWindow(String title, Parkeringshus parkeringshus, String bilNr) {

        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.parkeringshus = parkeringshus;
        this.bilNr = bilNr;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }
    // -------------------------------------------------------------------------

    private Label lblError;
    private ComboBox<Parkeringsplads> cbbPPlads;
    private ComboBox<BilMærke> cbbBilMærke;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblPladsNr = new Label("Vælg plads nr");
        pane.add(lblPladsNr,0,0);

        cbbPPlads = new ComboBox<>();
        pane.add(cbbPPlads,0,1);
        cbbPPlads.getItems().addAll(parkeringshus.getParkeringspladser());

        Label lblName = new Label("Vælg mærke");
        pane.add(lblName, 1, 0);

        cbbBilMærke = new ComboBox<>();
        pane.add(cbbBilMærke, 1, 1);
        cbbBilMærke.getItems().addAll(BilMærke.values());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 2);
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 2);
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
        BilMærke bilMærke = cbbBilMærke.getSelectionModel().getSelectedItem();
        Parkeringsplads parkeringsplads = cbbPPlads.getSelectionModel().getSelectedItem();
        if (bilMærke == null) {
            lblError.setText("Vælg et bilmærke");
        } else if (parkeringsplads == null) {
            lblError.setText("Vælg en P-plads");
        } else if (parkeringsplads.getBil() != null) {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Error");
            dialog.setHeaderText("Bil er allerede parket på pladsen");
            dialog.showAndWait();
        }else {
            Bil bil = Controller.createBil(bilNr,bilMærke);
            Controller.addBilToParkeringspladsNr(bil,parkeringsplads);
            hide();
        }
    }
}
