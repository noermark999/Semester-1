package Lek15.gui;

import Lek15.Application.Controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerWindow extends Stage {

	public CustomerWindow(String title) {
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setResizable(false);

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfAge, txfLicenseID, txfCPRNR;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Name");
		pane.add(lblName, 0, 0);

		txfName = new TextField();
		pane.add(txfName, 0, 1);
		txfName.setPrefWidth(200);

		Label lblHourly_wage = new Label("Age");
		pane.add(lblHourly_wage, 0, 2);

		txfAge = new TextField();
		pane.add(txfAge, 0, 3);

		Label lblHours = new Label("License ID");
		pane.add(lblHours, 0, 4);

		txfCPRNR = new TextField();
		pane.add(txfCPRNR, 0, 5);

		Label lblEmploymentYear = new Label("CPR-Nr");
		pane.add(lblEmploymentYear,0,7);

		txfLicenseID = new TextField();
		pane.add(txfLicenseID,0,8);
		txfLicenseID.setDisable(true);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 10);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 10);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> okAction());

		lblError = new Label();
		pane.add(lblError, 0, 11);
		lblError.setStyle("-fx-text-fill: red");

		initControls();
	}

	private void initControls() {
			txfName.clear();
			txfCPRNR.clear();
			txfAge.clear();
			txfLicenseID.clear();

	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		hide();
	}

	private void okAction() {
		String name = txfName.getText().trim();
		int age = Integer.parseInt(txfAge.getText());
		long licenseid = Long.parseLong(txfLicenseID.getText());
		long cprNr = Long.parseLong(txfCPRNR.getText());
		int employmentYear = Integer.parseInt(txfLicenseID.getText());
		if (name.length() == 0) {
			lblError.setText("Name is empty");
		} else {
			int wage = -1;
			try {
				wage = Integer.parseInt(txfAge.getText().trim());
			} catch (NumberFormatException ex) {
				// do nothing
			}
			if (wage < 0) {
				lblError.setText("Wage is not a positive number");
			} else {
				int hours = -1;
				try {
					hours = Integer.parseInt(txfCPRNR.getText().trim());
				} catch (NumberFormatException ex) {
					// do nothing
				}
				if (hours < 0) {
					lblError.setText("Hours is not a positive number");
				} else {
					Controller.createCustomer(name,age,licenseid,cprNr);
						}
					}
					hide();
				}
			}

	// -------------------------------------------------------------------------

}
