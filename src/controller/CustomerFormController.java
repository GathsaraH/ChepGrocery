package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class CustomerFormController {

    public Button txtBackButton;
    public AnchorPane rootPain;
    public TextField txtCustName;
    public TextField txtCustAddress;
    public TextField txtCustContact;
    public Button txtAddCustomer;

    public void btnBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.rootPain.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnAddCustomer(ActionEvent actionEvent) {
        String custName = txtCustName.getText();
        String custAddress = txtCustAddress.getText();
        String custContact = txtCustContact.getText();
        try {
            Customer customer = new Customer(custName, custAddress, custContact);
            boolean isAdded = CustomerController.AddCustomer(customer);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Customer added Successfully", "", JOptionPane.INFORMATION_MESSAGE);
                txtCustName.setText(null);
                txtCustAddress.setText(null);
                txtCustContact.setText(null);
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver Not Found");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Duplicate Entry", "", JOptionPane.WARNING_MESSAGE);
        }
    }
}
