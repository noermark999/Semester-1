package Gui;

import Application.Controller.KASController;
import Application.Model.Deltager;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeltagerWindow extends Stage {
    private Deltager deltager;

    private TextField txfName;
    private TextField txfTlf;
    private TextField txfAdresse;
    private TextField txfByLand;
    private TextField txfFirmaNavn;
    private TextField txfFirmaTlf;

    private CheckBox chkFir;

    public DeltagerWindow(String title, Deltager deltager) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.deltager = deltager;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    public DeltagerWindow(String title) {
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
        pane.add(txfName, 1, 0);


        Label lblTlf = new Label("Telefon nummer:");
        pane.add(lblTlf, 0, 1);

        txfTlf = new TextField();
        pane.add(txfTlf, 1, 1);


        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0, 2);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 1, 2);


        Label lblByLand = new Label("By eller land:");
        pane.add(lblByLand, 0, 3);

        txfByLand = new TextField();
        pane.add(txfByLand, 1, 3);


        Label lblFirmaNavn = new Label("Firma navn:");
        pane.add(lblFirmaNavn, 0, 5);

        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn, 1, 5);
        txfFirmaNavn.setDisable(true);


        Label lblFirmaTlf = new Label("Firma tlf:");
        pane.add(lblFirmaTlf, 0, 6);

        txfFirmaTlf = new TextField();
        pane.add(txfFirmaTlf, 1, 6);
        txfFirmaTlf.setDisable(true);


        Button butOk = new Button("Ok");
        pane.add(butOk, 0, 7);
        butOk.setOnAction(actionEvent -> this.addOkAction());


        Button butCan = new Button("Cancel");
        pane.add(butCan, 3, 7);
        butCan.setOnAction(actionEvent -> hide());

        chkFir = new CheckBox("Firma");
        pane.add(chkFir, 0, 4);

        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> selectedFirmaChanged(newValue);
        chkFir.selectedProperty().addListener(listener);

        this.initControls();

    }

    private void initControls() {
        boolean firmaSel = chkFir.isSelected();
        if (deltager != null) {
            txfName.setText(deltager.getNavn());
            txfTlf.setText(deltager.getTlf());
            txfByLand.setText(deltager.getByLand());
            txfAdresse.setText(deltager.getAdresse());
            chkFir.setSelected(deltager.getFirmaNavn() != null);
            txfFirmaNavn.setText(deltager.getFirmaNavn());
            txfFirmaTlf.setText(deltager.getFirmaTlf());
        } else {
            txfName.clear();
            txfTlf.clear();
            txfByLand.clear();
            txfAdresse.clear();
            txfFirmaNavn.clear();
            txfFirmaTlf.clear();
        }
    }

    private void selectedFirmaChanged(boolean checked) {
        boolean firmaSel = chkFir.isSelected();
        txfFirmaTlf.setDisable(!checked);
        txfFirmaNavn.setDisable(!checked);
        if (!firmaSel) {
            txfFirmaNavn.clear();
            txfFirmaTlf.clear();
        }
    }

    private void addOkAction() {
        String navn = txfName.getText().trim();
        String tlf = txfTlf.getText().trim();
        String adresse = txfAdresse.getText().trim();
        String byLand = txfByLand.getText().trim();
        boolean firmaSel = chkFir.isSelected();
        String firma = txfFirmaNavn.getText().trim();
        String firmaTlf = txfFirmaTlf.getText().trim();
        if (navn.length() == 0 || adresse.length() == 0 || byLand.length() == 0 || tlf.length() == 0) {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Error");
            dialog.setHeaderText("Angiv noget i alle felter");
            dialog.showAndWait();
        } else if (!firmaSel) {
            if (deltager == null) {
                KASController.createDeltager(navn, tlf, adresse, byLand,null,null);
                hide();
            } else {
                KASController.updateDeltager(deltager, navn, tlf, adresse, byLand,null,null);
                hide();
            }
        } else {
            if (firma.length() == 0 || firmaTlf.length() == 0) {
                Alert dialogFirma = new Alert(Alert.AlertType.INFORMATION);
                dialogFirma.setTitle("Error");
                dialogFirma.setHeaderText("Angiv både firma og firma telefon nr.");
                dialogFirma.showAndWait();
            } else {
                if (deltager == null) {
                    KASController.createDeltager(navn, tlf, adresse, byLand, firma, firmaTlf);
                    hide();
                } else {
                    KASController.updateDeltager(deltager, navn, tlf, adresse, byLand, firma, firmaTlf);
                    hide();
                }
            }
        }
    }
}

