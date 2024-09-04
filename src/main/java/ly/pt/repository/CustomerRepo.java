package ly.pt.repository;

import ly.pt.db.DbConnection;
import ly.pt.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepo {

    public static boolean Save(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (CustomerID,Name,Address,Contact) VALUES (?,?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, customer.getCustomerID());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getAddress());
        pstm.setString(4, customer.getContact());

        return pstm.executeUpdate() > 0;
    }
    public static boolean Update(Customer customer) throws SQLException {
        String sql = "UPDATE customers SET Name =?, Address =?, Contact =? WHERE CustomerID =?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, customer.getName());
        pstm.setString(2, customer.getAddress());
        pstm.setString(3, customer.getContact());
        pstm.setString(4, customer.getCustomerID());

        return pstm.executeUpdate() > 0;
    }
    public static boolean Delete(String customerID) throws SQLException {
        String sql = "DELETE FROM customers WHERE CustomerID =?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, customerID);

        return pstm.executeUpdate() > 0;
    }
}
