package GUI;

import Application.Model.Kamp;
import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class haandboldPane extends GridPane {
	private final ListView<Kamp> lvwKampe;
	private TextField txfSted, txfDato, txfTid;
	private Button btnOpret, btnOpdater, btnFil;

	public haandboldPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKampe = new Label("Kampe");
		this.add(lblKampe,0,0);

		lvwKampe = new ListView<>();
		this.add(lvwKampe, 0, 1, 1, 4);
		lvwKampe.setPrefHeight(200);
		lvwKampe.getItems().setAll(Storage.getKampe());
		ChangeListener<Kamp> listener = (ov, oldObj, newObj) -> this.selectedKampChanged();
		lvwKampe.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblSted = new Label("Spillested:");
		this.add(lblSted,1,0);

		txfSted = new TextField();
		this.add(txfSted,2,0);
		txfSted.setEditable(false);

		Label lblDato = new Label("Spillesdato:");
		this.add(lblDato,1,1);

		txfDato = new TextField();
		this.add(txfDato,2,1);
		txfDato.setEditable(false);

		Label lblTid = new Label("Spilletid:");
		this.add(lblTid,1,2);

		txfTid = new TextField();
		this.add(txfTid,2,2);
		txfTid.setEditable(false);

		btnOpret = new Button("Opret");
		this.add(btnOpret,2,3);
		btnOpret.setOnAction(event -> this.opretAction());

		btnOpdater = new Button("Opdater");
		this.add(btnOpdater,3,3);
		btnOpdater.setOnAction(event -> this.opdaterKampAction());

		btnFil = new Button("Lav fil");
		this.add(btnFil,2,4);
		btnFil.setOnAction(event -> this.lavFilAction());
	}

	private void selectedKampChanged() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if (kamp != null) {
			txfSted.setText(kamp.getSted());
			txfDato.setText(kamp.getDato().toString());
			txfTid.setText(kamp.getTid().toString());
		} else {
			txfSted.clear();
			txfTid.clear();
			txfDato.clear();
		}

	}

	private void opretAction() {
		OpretKampWindow dia = new OpretKampWindow("Opret Kamp");
		dia.showAndWait();
		lvwKampe.getItems().setAll(Storage.getKampe());

	}

	private void opdaterKampAction() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if (kamp != null) {
			OpretKampWindow dia = new OpretKampWindow("Opret Kamp", kamp);
			dia.showAndWait();
			lvwKampe.getItems().setAll(Storage.getKampe());
		}
	}

	private void lavFilAction() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if (kamp != null) {
			kamp.spillerHonorar("Fil");
		}
	}

}
