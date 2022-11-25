package Lek16.gui;

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
	private final TextField txfWage;
	private final TextField txfCompany;
	private final TextField txfSalary;
	private final TextField txfEmploymentYear;
	private final TextField txfHours;
	private final ListView<Employee> lvwEmployees;

	public CustomerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Employees");
		this.add(lblComp, 0, 0);

		lvwEmployees = new ListView<>();
		this.add(lvwEmployees, 0, 1, 1, 6);
		lvwEmployees.setPrefWidth(200);
		lvwEmployees.setPrefHeight(200);
		lvwEmployees.getItems().setAll(Controller.getEmployees());
		ChangeListener<Employee> listener = (ov, oldEmployee, newEmployee) -> this.selectedEmployeeChanged();
		lvwEmployees.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setPrefWidth(200);
		txfName.setEditable(false);

		Label lblWage = new Label("Hourly Wage:");
		this.add(lblWage, 1, 2);

		txfWage = new TextField();
		this.add(txfWage, 2, 2);
		txfWage.setEditable(false);

		Label lblHours = new Label("Weekly Hours:");
		this.add(lblHours, 1, 3);

		txfHours = new TextField();
		this.add(txfHours, 2, 3);
		txfHours.setEditable(false);

		Label lblCompany = new Label("Company:");
		this.add(lblCompany, 1, 4);

		txfCompany = new TextField();
		this.add(txfCompany, 2, 4);
		txfCompany.setEditable(false);

		Label lblSalary = new Label("Weekly Salary:");
		this.add(lblSalary, 1, 5);

		txfSalary = new TextField();
		this.add(txfSalary, 2, 5);
		txfSalary.setEditable(false);

		Label lblEmploymentYear = new Label("Employment Year");
		this.add(lblEmploymentYear,1,6);

		txfEmploymentYear = new TextField();
		this.add(txfEmploymentYear,2,6);
		txfEmploymentYear.setEditable(false);

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

		if (lvwEmployees.getItems().size() > 0) {
			lvwEmployees.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CustomerWindow dia = new CustomerWindow("Create Employee");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwEmployees.getItems().setAll(Controller.getEmployees());
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
		Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
		if (employee != null) {
			txfName.setText(employee.getName());
			txfHours.setText(String.valueOf(employee.getHours()));
			txfWage.setText("kr " + employee.getWage());
			if (employee.getCompany() != null) {
				txfCompany.setText("" + employee.getCompany());
				txfSalary.setText("kr " + employee.weeklySalary());
				txfEmploymentYear.setText(String.valueOf(employee.getEmploymentYear()));
			} else {
				txfCompany.clear();
				txfSalary.clear();
				txfEmploymentYear.clear();
			}
		} else {
			txfName.clear();
			txfWage.clear();
			txfHours.clear();
			txfCompany.clear();
			txfSalary.clear();
			txfEmploymentYear.clear();
		}
	}

}
