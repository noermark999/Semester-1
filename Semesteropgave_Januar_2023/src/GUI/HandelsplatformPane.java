package GUI;

import Application.Controller.Controller;
import Application.Model.Salg;
import Application.Model.Salgsannonce;
import Application.Model.Vare;
import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class HandelsplatformPane extends GridPane {
	private final ListView<Salgsannonce> lvwAnnoncer;
	private final ListView<Vare> lvwVare;
	private TextField txfKøber, txfAftPris, txfFilnavn;
	private Button btnOpret, btnFil;

	public HandelsplatformPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblannoncer = new Label("Aktive annoncer");
		this.add(lblannoncer,0,0);

		lvwAnnoncer = new ListView<>();
		this.add(lvwAnnoncer, 0, 1, 1, 4);
		lvwAnnoncer.setPrefHeight(300);
		lvwAnnoncer.setPrefWidth(300);
		lvwAnnoncer.getItems().setAll(Controller.aktiveAnnoncer());
		ChangeListener<Salgsannonce> listener = (ov, oldObj, newObj) -> this.selectedAnnonceChanged();
		lvwAnnoncer.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblVarer = new Label("Varer");
		this.add(lblVarer,1,0);

		lvwVare = new ListView<>();
		this.add(lvwVare, 1, 1, 1, 4);
		lvwVare.setPrefHeight(300);
		lvwVare.setPrefWidth(300);

		Label lblKøber = new Label("Køber");
		this.add(lblKøber,2,1);

		txfKøber = new TextField();
		this.add(txfKøber, 3,1);

		Label lblAftPris = new Label("Aftalt pris");
		this.add(lblAftPris,2,2);

		txfAftPris = new TextField();
		this.add(txfAftPris,3,2);

		btnOpret = new Button("Opret Salg");
		this.add(btnOpret,2,3);
		btnOpret.setOnAction(event -> this.opretAction());

		Label lblFilnavn = new Label("Fil navn");
		this.add(lblFilnavn,2,6);

		txfFilnavn = new TextField();
		this.add(txfFilnavn,3,6);

		btnFil = new Button("Salgs fil");
		this.add(btnFil,2,7);
		btnFil.setOnAction(event -> this.filAction());
	}

	private void selectedAnnonceChanged() {
		Salgsannonce salgsannonce = lvwAnnoncer.getSelectionModel().getSelectedItem();
		if (salgsannonce != null) {
			lvwVare.getItems().setAll(salgsannonce.getVare());
		} else {
			lvwVare.getItems().clear();
		}
	}

	private void opretAction() {
		Vare vare = lvwVare.getSelectionModel().getSelectedItem();
		String navn = txfKøber.getText();
		String pris = txfAftPris.getText();
		if (vare != null && navn.length() != 0 && pris.length() != 0) {
			if (!vare.isSolgt()) {
				Salg salg = Controller.createSalg(navn, Integer.parseInt(pris));
				salg.addVare(vare);
				txfKøber.clear();
				txfAftPris.clear();
				lvwAnnoncer.getItems().setAll(Controller.aktiveAnnoncer());
				selectedAnnonceChanged();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Vare er solgt");
				alert.setHeaderText("Kan ikke oprette salg da varen allerede er solgt");
				alert.showAndWait();
			}
		}
	}

	private void filAction() {
		String filnavn = txfFilnavn.getText();
		if (filnavn.length() != 0) {
			Controller.salgTilFil(filnavn);
		}
	}

}
