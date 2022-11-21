package Opgave3.Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

	
	@Override
	public void init() {

		//Controller.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Comparator Demo");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		CompanyPane companyPane = new CompanyPane();
		pane.setCenter(companyPane);
	}



}
