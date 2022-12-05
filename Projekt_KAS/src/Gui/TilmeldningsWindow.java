package Gui;

import Application.Controller.KASController;
import Application.Model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class TilmeldningsWindow extends Stage {
    private Konference konference;

    private DatePicker anDate, afDate;

    private ComboBox<Deltager> cbbDeltager;

    private ComboBox<Hotel> cbbHotel;

    private RadioButton[] rbUdflugt;

    private RadioButton[] rbService;

    private TextField txfLed;

    private CheckBox chkFor, chkLed;

    private Button butOk, butCl;

    private GridPane pane;
    private HBox hBox1;

    public TilmeldningsWindow(String title, Konference konference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;

        this.setTitle(title);
        pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        //this.setHeight(340);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10,10,50,10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDel = new Label("Deltagere");
        pane.add(lblDel, 0, 0);

        cbbDeltager = new ComboBox<>();
        pane.add(cbbDeltager, 1, 0);
        cbbDeltager.getItems().addAll(KASController.getDeltager());

        Label lblAn = new Label("Ankomst Dato");
        pane.add(lblAn, 0, 1);

        anDate = new DatePicker();
        pane.add(anDate, 1, 1);

       LocalDate minDate =  konference.getStartDato();
       LocalDate maxDate =  konference.getSlutDato();
       anDate.setDayCellFactory(d -> new DateCell() {
           @Override public void updateItem(LocalDate item, boolean empty) {
               super.updateItem(item, empty);
               setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
           }});

        Label lblAf = new Label("Afrejse Dato");
        pane.add(lblAf, 0, 2);

        afDate = new DatePicker();
        pane.add(afDate, 1, 2);

        afDate.setDayCellFactory(d -> new DateCell() {
            @Override public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
            }});

        Label lblHot = new Label("Hotel");
        pane.add(lblHot, 0, 3);

        cbbHotel = new ComboBox<>();
        pane.add(cbbHotel, 1, 3);
        cbbHotel.getItems().addAll(konference.getHotels());
        cbbHotel.setOnAction(event -> this.cbbHotelAction());

        hBox1 = new HBox(15);
        pane.add(hBox1, 1, 4);

        Label lblUd = new Label("Udflugter");
        pane.add(lblUd, 0, 8);

        HBox hBox = new HBox(15);
        pane.add(hBox, 1, 8);

        rbUdflugt = new RadioButton[konference.getUdflugter().size()];
        for (int i = 0; i < konference.getUdflugter().size(); i++) {
            rbUdflugt[i] = new RadioButton();
            rbUdflugt[i].setText(String.valueOf(konference.getUdflugter().get(i).getNavn()));
            hBox.getChildren().add(rbUdflugt[i]);
            rbUdflugt[i].setDisable(true);
            rbUdflugt[i].setUserData(konference.getUdflugter().get(i));
            rbUdflugt[i].setOnAction(event -> this.rbUdlfugtAction());
        }

        Label lblLed = new Label("Ledsager");
        pane.add(lblLed, 0, 6);

        chkLed = new CheckBox();
        pane.add(chkLed, 1, 6);
        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> selectedLedsagerChanged(newValue);
        chkLed.selectedProperty().addListener(listener);

        Label lblLedNavn = new Label("Ledsager Navn");
        pane.add(lblLedNavn, 0, 7);

        txfLed = new TextField();
        pane.add(txfLed, 1, 7);
        txfLed.setDisable(true);

        Label lblFor = new Label("Foredragsholder");
        pane.add(lblFor, 0, 5);

        chkFor = new CheckBox();
        pane.add(chkFor, 1, 5);

        butOk = new Button("Ok");
        pane.add(butOk, 0, 9);
        butOk.setOnAction(event -> this.okAction());

        butCl = new Button("Close");
        pane.add(butCl, 3, 9);
        butCl.setOnAction(event -> this.closeAction());
    }

    private void cbbHotelAction() {
        hBox1.getChildren().clear();
        if (cbbHotel.getSelectionModel().getSelectedItem() != null) {
            rbService = new RadioButton[cbbHotel.getSelectionModel().getSelectedItem().getServices().size()];
            for (int i = 0; i < cbbHotel.getSelectionModel().getSelectedItem().getServices().size(); i++) {
                rbService[i] = new RadioButton();
                rbService[i].setText(String.valueOf(cbbHotel.getSelectionModel().getSelectedItem().getServices().get(i).getNavn()));
                hBox1.getChildren().add(rbService[i]);
                rbService[i].setDisable(false);
                rbService[i].setUserData(cbbHotel.getSelectionModel().getSelectedItem().getServices().get(i));
                rbService[i].setOnAction(event -> this.rbServiceAction());
            }
        }
    }

    private void rbServiceAction() {

    }


    private void rbUdlfugtAction() {

    }

    private void closeAction() {
        this.hide();
    }

    private void selectedLedsagerChanged(boolean checked) {
        txfLed.setDisable(!checked);
        for (int i = 0; i < rbUdflugt.length; i++) {
            rbUdflugt[i].setDisable(!checked);
        }
    }

    private void okAction() {
        Deltager deltager = cbbDeltager.getSelectionModel().getSelectedItem();
        LocalDate localDate = anDate.getValue();
        LocalDate localDate1 = afDate.getValue();
        Hotel hotel = cbbHotel.getSelectionModel().getSelectedItem();
        boolean forHolder = chkFor.isSelected();
        boolean ledsager = chkLed.isSelected();
        String ledsagerNavn = txfLed.getText().trim();

        if (deltager == null || localDate == null || localDate1 == null) {
            Alert dialogFirma = new Alert(Alert.AlertType.INFORMATION);
            dialogFirma.setTitle("Error");
            dialogFirma.setHeaderText("Angiv noget i alle felter");
            dialogFirma.showAndWait();
        } else {
            if (hotel == null) {
                if (ledsager) {
                    Tilmelding tilmelding = KASController.createTilmeldning(deltager, konference, forHolder, ledsagerNavn, localDate, localDate1);
                    for (int i = 0; i < rbUdflugt.length; i++) {
                        if (rbUdflugt[i].isSelected()) {
                            KASController.addUdflugtTilTilmeldning((Udflugt) rbUdflugt[i].getUserData(), tilmelding);
                        }
                    }

                    hide();
                } else {
                    KASController.createTilmeldning(deltager, konference, forHolder, localDate, localDate1);

                }
            } else {
                if (ledsager) {
                    Tilmelding tilmelding = KASController.createTilmeldning(deltager, konference, forHolder, ledsagerNavn, localDate, localDate1);
                    KASController.addHotelTilTilmeldning(hotel, tilmelding);
                    for (int i = 0; i < rbService.length; i++) {
                        if (rbService[i].isSelected()) {
                            KASController.addServiceTilTilmelding(hotel, tilmelding,rbService[i].getText());
                        }
                    }
                    for (int i = 0; i < rbUdflugt.length; i++) {
                        if (rbUdflugt[i].isSelected()) {
                            KASController.addUdflugtTilTilmeldning((Udflugt) rbUdflugt[i].getUserData(), tilmelding);
                        }
                    }
                    hide();
                } else {
                    Tilmelding tilmelding = KASController.createTilmeldning(deltager, konference, forHolder, localDate, localDate1);
                    KASController.addHotelTilTilmeldning(hotel, tilmelding);
                    for (int i = 0; i < rbService.length; i++) {
                        if (rbService[i].isSelected()) {
                            KASController.addServiceTilTilmelding(hotel, tilmelding, rbService[i].getText());
                        }
                    }
                    hide();
                }
            }
        }
    }
}
