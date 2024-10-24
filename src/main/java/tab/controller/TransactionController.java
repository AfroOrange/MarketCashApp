package tab.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import models.Prints;  // Ensure you have a Prints model
import models.Stickers;  // Ensure you have a Stickers model

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {

    // model
    private PrintsController printsController = new PrintsController();
    private StickerController stickerController = new StickerController();

    //view

    @FXML
    private TextField amountTextField;

    @FXML
    private ListView<String> cartListView;

    @FXML
    private ComboBox<String> formatComboBox;

    @FXML
    private ComboBox<String> nameComboBox;

    @FXML
    private TextField quantityField;

    @FXML
    private BorderPane root;

    @FXML
    private TextField totalFundsCount;

    @FXML
    private ComboBox<String> typeComboBox;

    private final List<Prints> printsList = new ArrayList<>(); // Sample list for Prints
    private final List<Stickers> stickersList = new ArrayList<>(); // Sample list for Stickers

    public TransactionController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TransactionsView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      typeComboBox.getItems().addAll(stickerController.getStickersList(), printsController.getPrintsList());
    }

    @FXML
    void onTypeAction(ActionEvent event) {
        typeComboBox.setOnAction(this::onTypeSelected);
        if (typeComboBox.getValue().equals("Prints")) {
            printsList.forEach(prints -> nameComboBox.getItems().add(prints.getName()));
            formatComboBox.getItems().addAll("A4", "A5");
        } else {
            stickersList.forEach(stickers -> nameComboBox.getItems().add(stickers.getName()));
            formatComboBox.getItems().addAll("Small", "Large");
        }
    }
    @FXML
    void onFormatAction(ActionEvent event) {

    }

    @FXML
    void onNameAction(ActionEvent event) {

    }

    @FXML
    void onAddAction(ActionEvent event) {
        // Logic for adding quantity
        int quantity = Integer.parseInt(quantityField.getText());
        quantity += 1;
        quantityField.setText(String.valueOf(quantity));
    }

    @FXML
    void onSubstracAction(ActionEvent event) {
        // Logic for subtracting quantity
        int quantity = Integer.parseInt(quantityField.getText());
        if (quantity > 0) {
            quantity -= 1;
            quantityField.setText(String.valueOf(quantity));
        }
    }

    @FXML
    void onSellAction(ActionEvent event) {
        // Logic for selling the item
    }

    public BorderPane getRoot() {
        return root;
    }

    private void onTypeSelected(ActionEvent event) {
        if (typeComboBox.getValue().equals("Prints")) {
            printsList.forEach(prints -> nameComboBox.getItems().add(prints.getName()));
        } else {
            stickersList.forEach(stickers -> nameComboBox.getItems().add(stickers.getName()));
        }
    }
}
