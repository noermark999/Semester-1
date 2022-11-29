package Lek15.gui;

import Lek15.Application.Controller.Controller;
import Lek15.Application.Model.Customer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class CustomerPane extends GridPane {
	private final TextField txfName;
	private final TextField txfAge;
	private final TextField txfCpr;
	private final TextField txfSalary;
	private final TextField txfEmploymentYear;
	private final TextField txfLicense;
	private final ListView<Customer> lvwCustomer;

	public CustomerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Employees");
		this.add(lblComp, 0, 0);

		lvwCustomer = new ListView<>();
		this.add(lvwCustomer, 0, 1, 1, 6);
		lvwCustomer.setPrefWidth(200);
		lvwCustomer.setPrefHeight(200);
		lvwCustomer.getItems().setAll(Controller.getCustomers());
		ChangeListener<Customer> listener = (ov, oldValue, newValue) -> this.selectedEmployeeChanged();
		lvwCustomer.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setPrefWidth(200);
		txfName.setEditable(false);

		Label lblAge = new Label("Age:");
		this.add(lblAge, 1, 2);

		txfAge = new TextField();
		this.add(txfAge, 2, 2);
		txfAge.setEditable(false);

		Label lblLicense = new Label("Driver license ID:");
		this.add(lblLicense, 1, 3);

		txfLicense = new TextField();
		this.add(txfLicense, 2, 3);
		txfLicense.setEditable(false);

		Label lblCpr = new Label("CPR-Nr");
		this.add(lblCpr, 1, 4);

		txfCpr = new TextField();
		this.add(txfCpr, 2, 4);
		txfCpr.setEditable(false);

		Label lblSalary = new Label("Weekly Salary:");
		this.add(lblSalary, 1, 5);

		HBox hbxButtons = new HBox(20);
		this.add(hbxButtons, 0, 8, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_LEFT);
		//hbxButtons.setBackground(Background.fill(Paint.valueOf("RED")));

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		HBox hbxClose = new HBox(20);
		this.add(hbxClose, 2, 8, 1, 1);
		hbxClose.setPadding(new Insets(10, 0, 0, 0));
		hbxClose.setAlignment(Pos.BASELINE_RIGHT);
		//hbxClose.setBackground(Background.fill(Paint.valueOf("BLUE")));

		Button btnClose = new Button("Close");
		hbxClose.getChildren().add(btnClose);
		btnClose.setOnAction(event -> this.closeAction());

		if (lvwCustomer.getItems().size() > 0) {
			lvwCustomer.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CustomerWindow dia = new CustomerWindow("Create Customer");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwCustomer.getItems().setAll(Controller.getCustomers());
		this.updateControls();
	}

	private void closeAction() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Employee");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Are you sure?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Platform.exit();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedEmployeeChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Employee employee = lvwCustomer.getSelectionModel().getSelectedItem();
		if (employee != null) {
			txfName.setText(employee.getName());
			txfLicense.setText(String.valueOf(employee.getHours()));
			txfAge.setText("kr " + employee.getWage());
			if (employee.getCompany() != null) {
				txfCpr.setText("" + employee.getCompany());
				txfSalary.setText("kr " + employee.weeklySalary());
				txfEmploymentYear.setText(String.valueOf(employee.getEmploymentYear()));
			} else {
				txfCpr.clear();
				txfSalary.clear();
				txfEmploymentYear.clear();
			}
		} else {
			txfName.clear();
			txfAge.clear();
			txfLicense.clear();
			txfCpr.clear();
			txfSalary.clear();
			txfEmploymentYear.clear();
		}
	}

}
