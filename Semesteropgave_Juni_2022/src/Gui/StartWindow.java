package Gui;

import Application.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

	
	@Override
	public void init() {

		Controller.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Kantinens vagtplanlægning");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		KantinePane KantinePane = new KantinePane();
		pane.setCenter(KantinePane);
	}



}
