package ly.pt.repository;

import ly.pt.db.DbConnection;
import ly.pt.model.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class itemRepo {
    public static boolean Save (item item) throws SQLException {
        String sql = "INSERT INTO items (Code,ItemName,Quantity,Price) VALUES (?,?,?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, item.getCode());
        pstm.setString(2, item.getItemName());
        pstm.setString(3, item.getQTY());
        pstm.setString(4, item.getPrice());

        return pstm.executeUpdate() > 0;
    }

    public static boolean Update(item item) throws SQLException {
        String sql = "UPDATE items SET ItemName=?, Quantity=?, Price=? WHERE Code=?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, item.getItemName());
        pstm.setString(2, item.getQTY());
        pstm.setString(3, item.getPrice());
        pstm.setString(4, item.getCode());

        return pstm.executeUpdate() > 0;
    }

    public static boolean Delete(String code) throws SQLException {
        String sql = "DELETE FROM items WHERE Code =?";

        Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, code);

            return pstm.executeUpdate() > 0;
    }
}
