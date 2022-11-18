package Gui;

import Application.Controller.CustomerController;
import Application.Controller.SortByAddress;
import Application.Controller.SortByCategory;
import Application.Controller.SortByName;
import Application.Model.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class CompanyPane extends GridPane {
	private ListView<Customer> lvwCustomers;
	private TextField txfFilterName = new TextField();
	private ToggleGroup toggleGroup = new ToggleGroup();
	private RadioButton[] radioButton = new RadioButton[Customer.SizeCategory.values().length];
	private RadioButton rbAll = new RadioButton("ALL");

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		HBox hbxFilterName = new HBox(40);
		this.add(hbxFilterName, 0, 0, 3, 1);
		hbxFilterName.setPadding(new Insets(10, 0, 0, 0));
		hbxFilterName.setAlignment(Pos.BASELINE_CENTER);

		Label lblFilterName = new Label("Search name");
		this.add(lblFilterName,0,0);
		hbxFilterName.getChildren().add(lblFilterName);

		this.add(txfFilterName,1,0);
		hbxFilterName.getChildren().add(txfFilterName);
		txfFilterName.textProperty().addListener(event -> this.filterByName());

		HBox hBox = new HBox(15);
		this.add(hBox,0,1);
		hBox.setPadding(new Insets(10, 0, 0, 0));
		hBox.setAlignment(Pos.BASELINE_CENTER);

		for (int i = 1; i<Customer.SizeCategory.values().length;i++) {
			radioButton[i] = new RadioButton();
			radioButton[i].setText(String.valueOf(Customer.SizeCategory.values()[i]));
			hBox.getChildren().add(radioButton[i]);
			radioButton[i].setUserData(Customer.SizeCategory.values()[i]);
			radioButton[i].setToggleGroup(toggleGroup);
			radioButton[i].setOnAction(event -> this.radioButtonAction());
		}

		hBox.getChildren().add(rbAll);
		rbAll.setToggleGroup(toggleGroup);
		rbAll.setOnAction(event -> rbAllAction());
		rbAll.setSelected(true);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 2);

		lvwCustomers = new ListView<>();
		this.add(lvwCustomers, 0, 3, 1, 3);
		lvwCustomers.setPrefWidth(600);
		lvwCustomers.setPrefHeight(300);
		lvwCustomers.getItems().setAll(CustomerController.getCustomers());


		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 6, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("By Name");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.orderByName());

		Button btnUpdate = new Button("By Address");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.orderByAddress());

		Button btnDelete = new Button("By Category");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.orderBySizeCategory());

		Button btnReset = new Button("Reset");
		hbxButtons.getChildren().add(btnReset);
		btnReset.setOnAction(event -> this.resetAction());

	}


	// -------------------------------------------------------------------------
	private void resetAction() {
		lvwCustomers.getItems().setAll(CustomerController.getCustomers());
	}

	private void orderByName() {
		lvwCustomers.getItems().sort(new SortByName());
	}

	private void orderByAddress() {
		lvwCustomers.getItems().sort(new SortByAddress());
	}

	private void orderBySizeCategory() {
		lvwCustomers.getItems().sort(new SortByCategory());
	}

	private void filterByName() {
		lvwCustomers.getItems().setAll(CustomerController.filterByName(CustomerController.getCustomers(),txfFilterName.getText()));
	}

	private void radioButtonAction() {
		RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
		Customer.SizeCategory companySize = (Customer.SizeCategory) radioButton.getUserData();
		lvwCustomers.getItems().setAll(CustomerController.filterByCategory(CustomerController.getCustomers(),companySize));
	}

	private void rbAllAction() {
		lvwCustomers.getItems().setAll(CustomerController.getCustomers());
	}

}
