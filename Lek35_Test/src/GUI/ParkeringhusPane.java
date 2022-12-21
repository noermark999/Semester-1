package GUI;

import Application.Controller.Controller;
import Application.Model.Parkeringshus;
import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ParkeringhusPane extends GridPane {
	private final ListView<Parkeringshus> lvwPHuse;
	private final ListView<String> lvwPPladser;
	private final TextField txfBilNr;

	public ParkeringhusPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblPHuse = new Label("Parkeringshuse");
		this.add(lblPHuse, 0, 0);

		lvwPHuse = new ListView<>();
		this.add(lvwPHuse, 0, 1, 1, 3);
		lvwPHuse.setPrefHeight(200);
		lvwPHuse.setPrefWidth(300);
		lvwPHuse.getItems().setAll(Storage.getParkeringshuse());
		ChangeListener<Parkeringshus> listener = (ov, oldObj, newObj) -> this.selectedPHusChanged();
		lvwPHuse.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblPladser = new Label("Optagne Pladser");
		this.add(lblPladser,1,0);

		lvwPPladser = new ListView<>();
		this.add(lvwPPladser,1,1,1,3);
		lvwPPladser.setPrefHeight(200);
		lvwPPladser.setPrefWidth(300);

		Label lblOpretBil = new Label("Opret bil med nummmer");
		this.add(lblOpretBil,0,5);

		txfBilNr = new TextField();
		this.add(txfBilNr,1,5);

		HBox hBox = new HBox(10);
		this.add(hBox,1,6);

		Button btnOpret = new Button("Opret");
		hBox.getChildren().add(btnOpret);
		btnOpret.setOnAction(event -> this.opretBilAction());

		Button btnAddress = new Button("By Address");
		hBox.getChildren().add(btnAddress);
		btnAddress.setOnAction(event -> this.byaddress());

		Button btnledig = new Button("By Ledige pladser");
		hBox.getChildren().add(btnledig);
		btnledig.setOnAction(event -> this.byledigepladser());


	}

	private void byledigepladser() {
		lvwPHuse.getItems().setAll(Controller.sortByLedigepladser());
	}

	private void byaddress() {
		lvwPHuse.getItems().setAll(Controller.sortByAdress());
	}

	private void selectedPHusChanged() {
		Parkeringshus parkeringshus = lvwPHuse.getSelectionModel().getSelectedItem();
		lvwPPladser.getItems().setAll(parkeringshus.optagnePladser());
	}

	// -------------------------------------------------------------------------

	private void opretBilAction() {
		Parkeringshus parkeringshus = lvwPHuse.getSelectionModel().getSelectedItem();
		if (parkeringshus != null && txfBilNr.getText().length() > 0) {
			OpretBilWindow dia = new OpretBilWindow("Parker bil", parkeringshus, txfBilNr.getText());
			dia.showAndWait();
			selectedPHusChanged();
			txfBilNr.clear();
		}
	}

}
