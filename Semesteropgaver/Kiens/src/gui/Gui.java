package gui;


import application.controller.Controller;
import application.model.Bane;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;


public class Gui extends Application {

    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Booking af tennisbaner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------
    private ListView<Bane> lvwBaner;
    private ListView<LocalTime> lvwLedigTider;

    //private OpretKampVindue opretKampVindue;

    private TextField txfDato;


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        lvwBaner = new ListView<>();
        pane.add(lvwBaner, 0, 3,1,1);
        lvwBaner.setPrefSize(220, 300);
        lvwBaner.getItems().setAll(Controller.getBaner());

        ChangeListener<Bane> listener = (ov, o, n) -> this.selectedBaneChanged();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(listener);

        //opretKampVindue = new OpretKampVindue("Opret Kamp", new Stage());


        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 0);

        txfDato = new TextField(LocalDate.now().toString());
        pane.add(txfDato, 0, 1);


        Label lblBaner = new Label("Baner");
        pane.add(lblBaner, 0, 2);

        Label lblLedigeTider = new Label("Ledige tider");
        pane.add(lblLedigeTider,1,0);
        lvwLedigTider = new ListView<>();
        pane.add(lvwLedigTider,1,1,1,3);
        lvwBaner.setPrefSize(220, 300);


        Button btnOpret = new Button("Opret bane");
        pane.add(btnOpret, 0, 5);
        btnOpret.setOnAction(event -> this.opretAction());

    }
    private void opretAction() {
        //opretKampVindue.showAndWait();
        //lvwBaner.getItems().setAll(Controller.getKampe());
    }

    private void selectedBaneChanged() {
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        lvwLedigTider.getItems().setAll(bane.getLedigeTiderPaaDag(LocalDate.parse(txfDato.getText())));
        }
    }

