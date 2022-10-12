package Opgave3;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PersonInput extends Stage {

    public PersonInput(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox chkSenior = new CheckBox();
    private Person p = null;

    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 1, 0, 2, 1);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);

        pane.add(txfTitle, 1, 1, 2, 1);

        Label lblActive = new Label("Senior:");
        pane.add(lblActive, 0, 2);

        pane.add(chkSenior, 1, 2);

        Button btnAdd = new Button("OK");
        pane.add(btnAdd, 6, 0);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel,6,1);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

        btnCancel.setOnAction(event -> cancelAction());
    }

    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        if (name.length() > 0 && title.length() > 0) {
            this.p = new Person(name,title,chkSenior.isSelected());
            clearBoxes();
            close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add person");
            alert.setHeaderText("No named or title typed");
            alert.setContentText("Type the name and title of the person");
            alert.show();
        }
    }
    private void cancelAction() {
        clearBoxes();
        p = null;
        close();
    }

    public Person getP() {
        return p;
    }

    private void clearBoxes() {
        txfName.clear();
        txfTitle.clear();
        chkSenior.setSelected(false);
    }

}
