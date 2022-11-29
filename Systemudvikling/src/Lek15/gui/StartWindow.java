package Lek15.gui;
/**
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

	
	//@Override
	//public void init() {
	//	Controller.init();
	//}

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

		Tab tabCompanies = new Tab("Companies");
		tabPane.getTabs().add(tabCompanies);

		CarPane carPane = new CarPane();
		tabCompanies.setContent(carPane);
		tabCompanies.setOnSelectionChanged(event -> carPane.updateControls());

		Tab tabEmployees = new Tab("Employees");
		tabPane.getTabs().add(tabEmployees);

		CustomerPane customerPane = new CustomerPane();
		tabEmployees.setContent(customerPane);
		tabEmployees.setOnSelectionChanged(event -> customerPane.updateControls());
	}

}
**/