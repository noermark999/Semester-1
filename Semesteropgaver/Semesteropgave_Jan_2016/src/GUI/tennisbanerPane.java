package GUI;

import Application.Model.Bane;
import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class tennisbanerPane extends GridPane {
	private final ListView<Bane> lvwBaner;
	private final ListView<LocalTime> lvwLedigTider;
	private final TextField txfDato;
	private final Button btnOpret;

	public tennisbanerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblDato = new Label("Dato");
		this.add(lblDato, 0, 0);

		txfDato = new TextField(LocalDate.now().toString());
		this.add(txfDato,0,1);

		Label lblBaner = new Label("Baner");
		this.add(lblBaner,0,2);

		lvwBaner = new ListView<>();
		this.add(lvwBaner, 0, 3, 1, 1);
		lvwBaner.getItems().setAll(Storage.getBaner());
		ChangeListener<Bane> listener = (ov, oldObj, newObj) -> this.selectedBaneChanged();
		lvwBaner.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblLedigeTider = new Label("Ledige Tider");
		this.add(lblLedigeTider,1,0);

		lvwLedigTider = new ListView<>();
		this.add(lvwLedigTider,1,1,1,3);

		btnOpret = new Button("Opret Bane");
		this.add(btnOpret,0,5);
		btnOpret.setOnAction(event -> this.opretBaneAction());
	}

	private void selectedBaneChanged() {
		Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
		lvwLedigTider.getItems().setAll(bane.getLedigeTiderPaaDag(LocalDate.parse(txfDato.getText())));
	}

	private void opretBaneAction() {
		OpretBaneWindow dia = new OpretBaneWindow("Opret bane");
		dia.showAndWait();
		lvwBaner.getItems().setAll(Storage.getBaner());

	}

}
