package tab.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Prints;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PrintsController implements Initializable {

    private final String FILE_PATH = "jsonFiles/prints.json";

    @FXML
    private TableView<Prints> printInformationTable;

    @FXML
    private TableColumn<Prints, String> nameColumn;

    @FXML
    private TableColumn<Prints, String> formatColumn;

    @FXML
    private TableColumn<Prints, Double> priceColumn;

    @FXML
    private TableColumn<Prints, Integer> quantityColumn;

    @FXML
    private AnchorPane root;

    public PrintsController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PrintsCountView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up the columns to map to the Prints model
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        formatColumn.setCellValueFactory(new PropertyValueFactory<>("format"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        try {
            showPrintData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showPrintData() throws IOException {
        Gson gson = new Gson();

        Path jsonFilePath = Paths.get(FILE_PATH);

        if (!Files.exists(jsonFilePath)) {
            throw new FileNotFoundException("The file " + FILE_PATH + " was not found");
        }

        String jsonContent = Files.readString(jsonFilePath);
        List<Prints> printsList = gson.fromJson(jsonContent, new TypeToken<List<Prints>>() {}.getType());

        printInformationTable.getItems().clear();
        printInformationTable.getItems().addAll(printsList); // Add prints to the table
    }

    // gettters and setters
    public AnchorPane getRoot() {
        return root;
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public TableView<Prints> getPrintInformationTable() {
        return printInformationTable;
    }

    public void setPrintInformationTable(TableView<Prints> printInformationTable) {
        this.printInformationTable = printInformationTable;
    }

    public TableColumn<Prints, String> getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(TableColumn<Prints, String> nameColumn) {
        this.nameColumn = nameColumn;
    }

    public TableColumn<Prints, String> getFormatColumn() {
        return formatColumn;
    }

    public void setFormatColumn(TableColumn<Prints, String> formatColumn) {
        this.formatColumn = formatColumn;
    }

    public TableColumn<Prints, Double> getPriceColumn() {
        return priceColumn;
    }

    public void setPriceColumn(TableColumn<Prints, Double> priceColumn) {
        this.priceColumn = priceColumn;
    }

    public TableColumn<Prints, Integer> getQuantityColumn() {
        return quantityColumn;
    }

    public void setQuantityColumn(TableColumn<Prints, Integer> quantityColumn) {
        this.quantityColumn = quantityColumn;
    }
}
