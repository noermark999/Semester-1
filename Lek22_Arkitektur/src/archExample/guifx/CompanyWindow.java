package archExample.guifx;

import archExample.application.controller.Controller;
import archExample.application.model.Company;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CompanyWindow extends Stage {
	private final Company company;

	public CompanyWindow(String title, Company company) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.company = company;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public CompanyWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private Label lblError;

	private final ToggleGroup toggleGroup = new ToggleGroup();
	private final RadioButton[] radioButton = new RadioButton[Company.companySize.values().length];

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

		HBox hBox = new HBox(15);
		pane.add(hBox,0,4);

		for (int i = 0; i<Company.companySize.values().length;i++) {
			radioButton[i] = new RadioButton();
			radioButton[i].setText(String.valueOf(Company.companySize.values()[i]));
			hBox.getChildren().add(radioButton[i]);
			radioButton[i].setUserData(Company.companySize.values()[i]);
			radioButton[i].setToggleGroup(toggleGroup);
			radioButton[i].setOnAction(event -> this.radioButtonAction());
		}

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 5);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 5);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 6);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private Company.companySize radioButtonAction() {
		RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
		return (Company.companySize) radioButton.getUserData();
	}

	private void initControls() {
		if (company != null) {
			txfName.setText(company.getName());
			radioButton[company.size.ordinal()].setSelected(true);
		} else {
			txfName.clear();
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		String name = txfName.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Name is empty");
		} else {
				// Call application.controller methods
				if (company != null) {
					Controller.updateCompany(company, name, radioButtonAction());
				} else {
					Controller.createCompany(name, radioButtonAction());
				}

				this.hide();
			}
		}
	}

