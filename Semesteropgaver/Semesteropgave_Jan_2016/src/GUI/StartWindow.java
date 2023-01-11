package GUI;

import Application.Controller.Service;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

	
	@Override
	public void init() {

		Service.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Booking af tennisbaner");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		tennisbanerPane tennisbanerPane = new tennisbanerPane();
		pane.setCenter(tennisbanerPane);
	}



}
