package Lek15.gui;
/**
import archExample.application.model.Company;
import archExample.application.model.Customer;
import archExample.application.model.Employee;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class CarPane extends GridPane {
	private final TextField txfName;
	private final TextField txfSize;
	private final TextArea txaEmps;
	private final TextArea txaCustomers;
	private final ListView<Company> lvwCompanies;
	private final ToggleGroup toggleGroup = new ToggleGroup();
	private final RadioButton[] radioButton = new RadioButton[Company.companySize.values().length];
	private final RadioButton rbAll = new RadioButton("Alle");

	public CarPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		HBox hBox = new HBox(15);
		this.add(hBox,0,1);

		for (int i = 0; i<Company.companySize.values().length;i++) {
			radioButton[i] = new RadioButton();
			radioButton[i].setText(String.valueOf(Company.companySize.values()[i]));
			hBox.getChildren().add(radioButton[i]);
			radioButton[i].setUserData(Company.companySize.values()[i]);
			radioButton[i].setToggleGroup(toggleGroup);
			radioButton[i].setOnAction(event -> this.radioButtonAction());
		}

		hBox.getChildren().add(rbAll);
		rbAll.setToggleGroup(toggleGroup);
		rbAll.setOnAction(event -> rbAllAction());
		rbAll.setSelected(true);

		lvwCompanies = new ListView<>();
		this.add(lvwCompanies, 0, 2, 1, 4);
		lvwCompanies.setPrefWidth(200);
		lvwCompanies.setPrefHeight(200);
		lvwCompanies.getItems().setAll(Controller.getCompanies());

		ChangeListener<Company> listener = (ov, oldCompny, newCompany) -> this.selectedCompanyChanged();
		lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 2);

		txfName = new TextField();
		this.add(txfName, 2, 2);
		txfName.setEditable(false);

		Label lblSize = new Label("Size:");
		this.add(lblSize, 1, 3);

		txfSize = new TextField();
		this.add(txfSize, 2, 3);
		txfSize.setEditable(false);

		Label lblEmps = new Label("Employees:");
		this.add(lblEmps, 1, 5);
		GridPane.setValignment(lblEmps, VPos.BASELINE);
		lblEmps.setPadding(new Insets(4, 0, 4, 0));

		txaEmps = new TextArea();
		this.add(txaEmps, 2, 5);
		txaEmps.setPrefWidth(200);
		txaEmps.setPrefHeight(100);
		txaEmps.setEditable(false);

		Label lblCustomers = new Label("Customers:");
		this.add(lblCustomers, 1, 6);
		GridPane.setValignment(lblCustomers, VPos.BASELINE);
		lblCustomers.setPadding(new Insets(4, 0, 4, 0));

		txaCustomers = new TextArea();
		this.add(txaCustomers,2,6);
		txaCustomers.setPrefWidth(200);
		txaCustomers.setPrefHeight(100);
		txaCustomers.setEditable(false);

		HBox hbxButtons = new HBox(20);
		this.add(hbxButtons, 0, 7, 3, 1);
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

		Button btnCustomer = new Button("Add Customer");
		hbxButtons.getChildren().add(btnCustomer);
		btnCustomer.setOnAction(event -> this.customerAction());

		HBox hbxClose = new HBox(20);
		this.add(hbxClose, 2, 7, 1, 1);
		hbxClose.setPadding(new Insets(10, 0, 0, 0));
		hbxClose.setAlignment(Pos.BASELINE_RIGHT);

		Button btnClose = new Button("Close");
		this.add(btnClose,2,7);
		hbxClose.getChildren().add(btnClose);
		btnClose.setOnAction(event -> this.closeAction());

		if (lvwCompanies.getItems().size() > 0) {
			lvwCompanies.getSelectionModel().select(0);
		}
	}

	private void rbAllAction() {
		lvwCompanies.getItems().setAll(Controller.getCompanies());
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CarWindow dia = new CarWindow("Create Company");
		dia.showAndWait();

		// Wait for the modal dialog to close

		if (rbAll.isSelected()) {
			rbAllAction();
		} else {
			radioButtonAction();
		}
		int index = lvwCompanies.getItems().size() - 1;
		lvwCompanies.getSelectionModel().select(index);
	}

	private void updateAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {

			CarWindow dia = new CarWindow("Update Company", company);
			dia.showAndWait();

			// Wait for the modal dialog to close

			int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
			if (rbAll.isSelected()) {
				rbAllAction();
			} else {
				radioButtonAction();
			}
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
	private void customerAction() {
		CustomerWindow dia = new CustomerWindow("Add customer");
		dia.showAndWait();
		updateControls();

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

	private void radioButtonAction() {
		RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
		Company.companySize companySize = (Company.companySize) radioButton.getUserData();
		switch (companySize) {
			case STOR, MELLEMSTOR, LILLE, MIKRO -> lvwCompanies.getItems().setAll(Controller.getCompaniesSize(companySize));
		}
	}

	public void updateControls() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			txfName.setText(company.getName());
			txfSize.setText(String.valueOf(company.size));
			StringBuilder sb = new StringBuilder();
			for (Employee emp : company.getEmployees()) {
				sb.append(emp + "\n");
			}
			txaEmps.setText(sb.toString());
			StringBuilder sb1 = new StringBuilder();
			for (Customer customer : company.getCustomers()) {
				sb1.append(customer.getName() + "\n");
			}
			txaCustomers.setText(sb1.toString());
		} else {
			txfName.clear();
			txaEmps.clear();
			txfSize.clear();
			txaCustomers.clear();
		}
	}

}

 **/