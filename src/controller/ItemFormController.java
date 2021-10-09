package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Item;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class ItemFormController {
    public AnchorPane rootText;
    public TextField txtItemName;
    public TextField txtTemQTY;

    public void btnAddItem(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String itemName=txtItemName.getText();
        String itemQty=txtTemQTY.getText();

        try{
            JOptionPane.showMessageDialog(null, "Item added Successfully", "", JOptionPane.INFORMATION_MESSAGE);
            Item item=new Item(itemName,itemQty);
            boolean isAdd=ItemController.addItem(item);
            if (isAdd){
                txtItemName.setText(null);
                txtTemQTY.setText(null);
            }else {
                JOptionPane.showMessageDialog(null,"Item added Field","",JOptionPane.ERROR_MESSAGE);
            }
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

    public void btnBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.rootText.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();
    }
}
