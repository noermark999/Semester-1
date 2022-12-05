package Gui;

import Application.Controller.KASController;
import Application.Model.Deltager;
import Application.Model.Udflugt;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class UdflugtWindow extends Stage {
    private Udflugt udflugt;

    private TextField txfName;
    private DatePicker DPDato;
    private TextField txfPris;
    private CheckBox chbFrokost;

    public UdflugtWindow(String title, Udflugt udflugt) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.udflugt = udflugt;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    public UdflugtWindow(String title) {
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
        txfName.setPrefWidth(200);


        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 0, 1);

        txfPris = new TextField();
        pane.add(txfPris, 1, 1);
        txfPris.setPrefWidth(200);

        Label lblFrokost = new Label("Frokost");
        pane.add(lblFrokost, 0, 2);

        chbFrokost = new CheckBox();
        chbFrokost.setSelected(false);
        pane.add(chbFrokost,1,2);

        Label lblDato = new Label();
        pane.add(lblDato,0,3);

        DPDato = new DatePicker();
        pane.add(DPDato,1,3);
        DPDato.setPrefWidth(200);
        DPDato.setEditable(false);

        Button butOk = new Button("Ok");
        pane.add(butOk, 0, 4);
        butOk.setOnAction(actionEvent -> this.addOkAction());

        Button butCan = new Button("Cancel");
        pane.add(butCan, 2, 4);
        butCan.setOnAction(actionEvent -> hide());

        this.initControls();

    }

    private void initControls() {
        if (udflugt != null) {
            txfName.setText(udflugt.getNavn());
            txfPris.setText(String.valueOf(udflugt.getPris()));
            DPDato.setValue(udflugt.getDato());
            chbFrokost.setSelected(udflugt.getFrokost());
        } else {
            txfName.clear();
            txfPris.clear();
            chbFrokost.setSelected(false);
            DPDato.getEditor().clear();
        }
    }

    private void addOkAction() {
        String navn = txfName.getText();
        boolean frokost = chbFrokost.isSelected();
        LocalDate dato = DPDato.getValue();
        if (navn.length() > 0 && txfPris.getText().length() > 0 && dato != null) {
            if (udflugt == null) {
                int pris = Integer.parseInt(txfPris.getText());
                KASController.createUdflugt(navn, dato, pris, frokost);
                hide();
            } else {
                int pris = Integer.parseInt(txfPris.getText());
                KASController.updateUdflugt(udflugt,navn,pris,dato,frokost);
                hide();
            }
        } else {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Error");
            dialog.setHeaderText("Angiv noget i alle felter");
            dialog.showAndWait();
        }
    }
}