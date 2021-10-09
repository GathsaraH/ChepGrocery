package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class mainFormController {

    public Button txtAddCustomer;
    public Button txtAddItem;
    public AnchorPane rootPain;

    public void btnAddCustomer(MouseEvent mouseEvent) {

    }

    public void btnAddItem(MouseEvent mouseEvent) {
    }

    public void btnAddCustomer(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.rootPain.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CustomerForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnAddItem(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.rootPain.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ItemForm.fxml"))));
        stage.centerOnScreen();
    }
}
