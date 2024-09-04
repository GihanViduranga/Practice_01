package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ly.pt.db.DbConnection;
import ly.pt.model.item;
import ly.pt.repository.itemRepo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemForm {

    public AnchorPane ItemRoot;

    public TextField txtCode;

    public TextField txtItemName;

    public TextField txtQTY;

    public TextField txtPrice;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String itemName = txtItemName.getText();
        String qty = txtQTY.getText();
        String price = txtPrice.getText();

        try {
            boolean isSaved = itemRepo.Save(new item(code,itemName,qty,price));
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Item Saved Successfully").show();
            }else {
                new Alert(Alert.AlertType.ERROR).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String itemName = txtItemName.getText();
        String qty = txtQTY.getText();
        String price = txtPrice.getText();



        try {
            boolean isUpdated = itemRepo.Update(new item(code,itemName,qty,price));
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Item Updated Successfully").show();
            }else {
                new Alert(Alert.AlertType.ERROR).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();

        try {
            boolean isDeleted = itemRepo.Delete(code);
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Item Deleted Successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR).show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtCode.setText("");
        txtItemName.setText("");
        txtQTY.setText("");
        txtPrice.setText("");
    }

    public void btnHomeOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/dashboard.fxml"));
            Stage stage = (Stage) ItemRoot.getScene().getWindow();

            stage.setScene(new Scene(anchorPane));
            stage.setTitle("Item Form");
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtItemScerchOnAction(ActionEvent actionEvent) {
        String id = txtCode.getText();

        String sql = "SELECT * FROM items WHERE Code =?";

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                txtItemName.setText(rs.getString("ItemName"));
                txtQTY.setText(rs.getString("Quantity"));
                txtPrice.setText(rs.getString("Price"));
            } else {
                new Alert(Alert.AlertType.ERROR, "Item not found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, "Item not found").show();
        }

    }
}
