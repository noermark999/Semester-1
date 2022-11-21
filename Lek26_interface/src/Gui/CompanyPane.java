package Gui;

import Application.Controller.*;
import Application.Model.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collections;

public class CompanyPane extends GridPane {
	private final ListView<Customer> lvwCustomers;

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwCustomers = new ListView<>();
		this.add(lvwCustomers, 0, 1, 1, 3);
		lvwCustomers.setPrefWidth(600);
		lvwCustomers.setPrefHeight(300);
		lvwCustomers.getItems().setAll(CustomerController.getCustomers());


		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 4, 3, 1);
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

	}

	// -------------------------------------------------------------------------

	private void orderByName() {
		lvwCustomers.getItems().sort(new SortByName());
	}

	private void orderByAddress() {
		lvwCustomers.getItems().sort(new SortByAddress());
	}

	private void orderBySizeCategory() {
		lvwCustomers.getItems().sort(new SortByCategory());
	}

}
