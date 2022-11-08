package archExample.guifx;

import archExample.application.controller.Controller;
import archExample.application.model.Company;
import archExample.application.model.Customer;
import archExample.application.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerWindow extends Stage {
	private Customer customer;

	public CustomerWindow(String title, Customer customer) {
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setResizable(false);

		this.customer = customer;

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	public CustomerWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private ComboBox<Company> cbbCompany;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Customer Name");
		pane.add(lblName, 0, 0);

		txfName = new TextField();
		pane.add(txfName, 0, 1);
		txfName.setPrefWidth(200);

		cbbCompany = new ComboBox<>();
		pane.add(cbbCompany, 0, 7);
		cbbCompany.getItems().addAll(Controller.getCompanies());

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 8);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 8);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> okAction());

		lblError = new Label();
		pane.add(lblError, 0, 9);
		lblError.setStyle("-fx-text-fill: red");

		initControls();
	}

	private void initControls() {
		txfName.clear();
		cbbCompany.getSelectionModel().select(0);
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		hide();
	}

	private void okAction() {
		String name = txfName.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Name is empty");
		} else {
			Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();
			customer = new Customer(name);
			Controller.createCustomer(name);
			Controller.addCustomerToCompany(customer, newCompany);
			hide();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedCompanyChanged(boolean checked) {
		cbbCompany.setDisable(!checked);
	}

}
