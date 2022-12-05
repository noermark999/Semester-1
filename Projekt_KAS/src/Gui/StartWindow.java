package Gui;

import Application.Controller.KASController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

	
	@Override
	public void init() {
		KASController.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Arcitecture Demo");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabKonference = new Tab("Konference");
		tabPane.getTabs().add(tabKonference);

		KonferencePane konferencePane = new KonferencePane();
		tabKonference.setContent(konferencePane);
		tabKonference.setOnSelectionChanged(event -> konferencePane.updateControls());

		Tab tabDeltager = new Tab("Deltager");
		tabPane.getTabs().add(tabDeltager);

		DeltagerPane deltagerPane = new DeltagerPane();
		tabDeltager.setContent(deltagerPane);
		tabDeltager.setOnSelectionChanged(event -> deltagerPane.updateControls());



		Tab tabHotel = new Tab("Hotel");
		tabPane.getTabs().add(tabHotel);

		HotelPane hotelPane = new HotelPane();
		tabHotel.setContent(hotelPane);
		tabHotel.setOnSelectionChanged(event -> hotelPane.updateControls());

		Tab tabUdflugt = new Tab("Udflugter");
		tabPane.getTabs().add(tabUdflugt);

		UdflugtPane udflugtPane = new UdflugtPane();
		tabUdflugt.setContent(udflugtPane);
		tabUdflugt.setOnSelectionChanged(event -> udflugtPane.updateControls());

	}

}
