package controller;

import model.Customer;
import model.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerController {
    public static boolean AddCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("Insert Into persons Values(?,?,?)");
        statement.setObject(1, customer.getCustomerName());
        statement.setObject(2, customer.getCustomerAddress());
        statement.setObject(3, customer.getCustomerContact());
        return statement.executeUpdate() > 0;
    }
}
