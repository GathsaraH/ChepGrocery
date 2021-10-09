package controller;

import model.DBConnection;
import model.Item;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemController {
    public static boolean addItem(Item item) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into Items Values(?,?)");
        stm.setObject(1,item.getItemName());
        stm.setObject(2,item.getItemQty());
        return stm.executeUpdate()>0;
    }
}
