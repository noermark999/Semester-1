package Gui;

import Application.Controller.Controller;
import Application.Model.Medarbejder;
import Application.Model.Vagt;
import Storage.Storage;
import com.sun.javafx.binding.StringFormatter;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class KantinePane extends GridPane {
	private final ListView<Medarbejder> lvwMedarbejdere;
	private final ListView<Vagt> lvwVagter;
	private final TextArea txaInfo;
	private Button btnTildel, btnFil;

	public KantinePane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKampe = new Label("Alle medarbejdere");
		this.add(lblKampe,0,0);

		lvwMedarbejdere = new ListView<>();
		this.add(lvwMedarbejdere, 0, 1, 1, 4);
		lvwMedarbejdere.setPrefHeight(300);
		lvwMedarbejdere.setPrefWidth(200);
		lvwMedarbejdere.getItems().setAll(Storage.getMedarbejdere());
		ChangeListener<Medarbejder> listener = (ov, oldObj, newObj) -> this.selectedMedarbejderChanged();
		lvwMedarbejdere.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblSted = new Label("Alle vagter");
		this.add(lblSted,1,0);

		lvwVagter = new ListView<>();
		this.add(lvwVagter, 1, 1, 1, 4);
		lvwVagter.setPrefHeight(300);
		lvwVagter.setPrefWidth(200);
		lvwVagter.getItems().setAll(Storage.getVagter());
		ChangeListener<Vagt> listener1 = (ov, oldObj, newObj) -> this.selectedVagtChanged();
		lvwVagter.getSelectionModel().selectedItemProperty().addListener(listener1);

		Label lblDato = new Label("Valgt vagt");
		this.add(lblDato,2,0);

		txaInfo = new TextArea();
		this.add(txaInfo,2,1,1,4);
		txaInfo.setPrefHeight(300);
		txaInfo.setPrefWidth(250);
		txaInfo.setEditable(false);

		btnTildel = new Button("Tildel vagt");
		this.add(btnTildel,1,5);
		btnTildel.setOnAction(event -> this.tildelAction());

		btnFil = new Button("Udskriv vagt til fil");
		this.add(btnFil,2,5);
		btnFil.setOnAction(event -> this.lavFilAction());
	}

	private void selectedMedarbejderChanged() {

	}

	private void selectedVagtChanged() {
		Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
		if (vagt != null) {
			txaInfo.setText("Navn: \t" + vagt.getNavn() + "\nFra:   \t" + vagt.getTidFra() + "\nTil:    \t" + vagt.getTidTil() + "\nStatus: \t" + vagt.status()
					+ "\nTilknyttede medarbejdere: \n" + getMedarbejdere(vagt));
		} else {
			txaInfo.clear();
		}
	}

	private String getMedarbejdere(Vagt vagt) {
		String res = "";
		for (Medarbejder medarbejder : vagt.getMedarbejdere()) {
			res = res.concat(medarbejder.getNavn() + " ");
		}
		return res;
	}

	private void tildelAction() {
		Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
		Medarbejder medarbejder = lvwMedarbejdere.getSelectionModel().getSelectedItem();
		if (vagt != null && medarbejder != null) {
			try {
				Controller.addMedarbejderToVagt(medarbejder,vagt);
			} catch (RuntimeException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Tildel vagt");
				alert.setHeaderText("Vagt kan ikke tildeles");
				alert.setContentText(e.getMessage());
				alert.show();
			}
		}
		selectedVagtChanged();
	}

	private void lavFilAction() {
		Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
		if (vagt != null) {
			Controller.udskrivVagtplan(vagt, "Vagtplan");
		}
	}

}
