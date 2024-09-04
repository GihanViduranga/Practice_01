package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ly.pt.model.Customer;
import ly.pt.repository.CustomerRepo;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerForm {

    public AnchorPane root;

    public TextField txtId;

    public TextField txtName;

    public TextField txtAddress;

    public TextField txtContact;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        try {
            boolean isSaved = CustomerRepo.Save(new Customer(id, name, address, contact));

            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION, "Customer saved").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Customer not saved").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        try {
            boolean isUpdated = CustomerRepo.Update(new Customer(id, name, address, contact));

            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION, "Customer updated").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Customer not updated").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            boolean isDeleted = CustomerRepo.Delete(id);

            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Customer not deleted").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
    }

    public void btnHomeOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/dashboard.fxml"));
            Stage stage = (Stage) root.getScene().getWindow();

            stage.setScene(new Scene(anchorPane));
            stage.setTitle("Item Form");
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

