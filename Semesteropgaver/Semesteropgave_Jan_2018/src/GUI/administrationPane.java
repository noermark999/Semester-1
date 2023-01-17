package GUI;

import Application.Controller.Controller;
import Application.Model.Arrangement;
import Application.Model.Tutor;
import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class administrationPane extends GridPane {
	private final ListView<Tutor> lvwTutors;
	private final ListView<Arrangement> lvwArrangementer, lvwAlleArrangementer;
	private TextField txfNavn, txfEmail;
	private Button btnFjern, btnTilføj;

	public administrationPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblTutorer = new Label("Tutorer");
		this.add(lblTutorer,0,0);

		lvwTutors = new ListView<>();
		this.add(lvwTutors, 0, 1, 1, 4);
		lvwTutors.setPrefHeight(300);
		lvwTutors.setPrefWidth(300);
		lvwTutors.getItems().setAll(Storage.getTutors());
		ChangeListener<Tutor> listener = (ov, oldObj, newObj) -> this.selectedTutorChanged();
		lvwTutors.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblNavn = new Label("Navn");
		this.add(lblNavn,1,0);

		txfNavn = new TextField();
		this.add(txfNavn, 2,0);
		txfNavn.setEditable(false);

		Label lblEmail = new Label("Email");
		this.add(lblEmail,1,1);

		txfEmail = new TextField();
		this.add(txfEmail, 2,1);
		txfEmail.setEditable(false);

		Label lblArrangementer = new Label("Arrangementer");
		this.add(lblArrangementer,1,2);

		lvwArrangementer = new ListView<>();
		this.add(lvwArrangementer, 2, 2, 1, 2);
		lvwArrangementer.setPrefHeight(150);
		lvwArrangementer.setPrefWidth(300);


		Label lblAlleArrangementer = new Label("Alle mulige arrangementer");
		this.add(lblAlleArrangementer,3,1);

		lvwAlleArrangementer = new ListView<>();
		this.add(lvwAlleArrangementer, 3, 2, 1, 2);
		lvwAlleArrangementer.setPrefHeight(150);
		lvwAlleArrangementer.setPrefWidth(300);
		lvwAlleArrangementer.getItems().setAll(Storage.getArrangementer());

		btnFjern = new Button("Fjern");
		this.add(btnFjern,2,4);
		btnFjern.setOnAction(event -> this.fjernAction());

		btnTilføj = new Button("Tilføj");
		this.add(btnTilføj,3,4);
		btnTilføj.setOnAction(event -> this.tilføjAction());
	}

	private void selectedTutorChanged() {
		Tutor tutor = lvwTutors.getSelectionModel().getSelectedItem();
		if (tutor != null) {
			txfNavn.setText(tutor.getNavn());
			txfEmail.setText(tutor.getEmail());
			lvwArrangementer.getItems().setAll(tutor.getArrangementer());
		} else {
			txfEmail.clear();
			txfEmail.clear();
			lvwArrangementer.getItems().clear();
		}
	}

	private void fjernAction() {
		Arrangement arrangement = lvwArrangementer.getSelectionModel().getSelectedItem();
		Tutor tutor = lvwTutors.getSelectionModel().getSelectedItem();
		if (arrangement != null) {
			Controller.removeArrangementFromTutor(arrangement,tutor);
			lvwArrangementer.getItems().setAll(tutor.getArrangementer());
		}
	}

	private void tilføjAction() {
		Tutor tutor = lvwTutors.getSelectionModel().getSelectedItem();
		Arrangement arrangement = lvwAlleArrangementer.getSelectionModel().getSelectedItem();
		if (tutor != null && arrangement != null) {
			Controller.addArrangementToTutor(arrangement,tutor);
			lvwArrangementer.getItems().setAll(tutor.getArrangementer());
		}
	}

}
