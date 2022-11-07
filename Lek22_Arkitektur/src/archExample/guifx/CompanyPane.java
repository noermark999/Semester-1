package archExample.guifx;

import java.util.Optional;

import archExample.application.controller.Controller;
import archExample.application.model.Company;
import archExample.application.model.Employee;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CompanyPane extends GridPane {
	private TextField txfName, txfHours;
	private TextArea txaEmps, txaCustomers;
	private ListView<Company> lvwCompanies;

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwCompanies = new ListView<>();
		this.add(lvwCompanies, 0, 1, 1, 3);
		lvwCompanies.setPrefWidth(200);
		lvwCompanies.setPrefHeight(200);
		lvwCompanies.getItems().setAll(Controller.getCompanies());

		ChangeListener<Company> listener = (ov, oldCompny, newCompany) -> this.selectedCompanyChanged();
		lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		Label lblHours = new Label("Weekly Hours:");
		this.add(lblHours, 1, 2);

		txfHours = new TextField();
		this.add(txfHours, 2, 2);
		txfHours.setEditable(false);

		Label lblEmps = new Label("Employees:");
		this.add(lblEmps, 1, 3);
		GridPane.setValignment(lblEmps, VPos.BASELINE);
		lblEmps.setPadding(new Insets(4, 0, 4, 0));

		txaEmps = new TextArea();
		this.add(txaEmps, 2, 3);
		txaEmps.setPrefWidth(200);
		txaEmps.setPrefHeight(100);
		txaEmps.setEditable(false);

		txaCustomers = new TextArea();
		this.add(txaCustomers,2,4);
		txaCustomers.setPrefWidth(200);
		txaCustomers.setPrefHeight(100);
		txaCustomers.setEditable(false);

		HBox hbxButtons = new HBox(20);
		this.add(hbxButtons, 0, 5, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_LEFT);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		HBox hbxClose = new HBox(20);
		this.add(hbxClose, 2, 5, 1, 1);
		hbxClose.setPadding(new Insets(10, 0, 0, 0));
		hbxClose.setAlignment(Pos.BASELINE_RIGHT);

		Button btnClose = new Button("Close");
		this.add(btnClose,2,5);
		hbxClose.getChildren().add(btnClose);
		btnClose.setOnAction(event -> this.closeAction());

		if (lvwCompanies.getItems().size() > 0) {
			lvwCompanies.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CompanyWindow dia = new CompanyWindow("Create Company");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwCompanies.getItems().setAll(Controller.getCompanies());
		int index = lvwCompanies.getItems().size() - 1;
		lvwCompanies.getSelectionModel().select(index);
	}

	private void updateAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {

			CompanyWindow dia = new CompanyWindow("Update Company", company);
			dia.showAndWait();

			// Wait for the modal dialog to close

			int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
			lvwCompanies.getItems().setAll(Controller.getCompanies());
			lvwCompanies.getSelectionModel().select(selectIndex);
		}
	}

	private void deleteAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {

			if (company.employeesCount() == 0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Company");
				// alert.setContentText("Are you sure?");
				alert.setHeaderText("Are you sure?");
				Optional<ButtonType> result = alert.showAndWait();
				if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
					Controller.deleteCompany(company);
					lvwCompanies.getItems().setAll(Controller.getCompanies());
					this.updateControls();
				}

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Delete Company");
				alert.setHeaderText("Can't delete a company that has employees"); //Opgave 1
				// wait for the modal dialog to close
				alert.show();
			}
		}
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

	private void selectedCompanyChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			txfName.setText(company.getName());
			txfHours.setText("" + company.getHours());
			StringBuilder sb = new StringBuilder();
			for (Employee emp : company.getEmployees()) {
				sb.append(emp + "\n");
			}
			txaEmps.setText(sb.toString());
		} else {
			txfName.clear();
			txfHours.clear();
			txaEmps.clear();
		}
	}

}
