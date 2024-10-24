package tab.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Stickers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

public class StickerController implements Initializable {

        private final String FILE_PATH = "jsonFiles/stickers.json";

        @FXML
        private TableColumn<Stickers, String> sizeColumn;

        @FXML
        private TableColumn<Stickers, String> nameColumn;

        @FXML
        private TableColumn<Stickers, Double> priceColumn;

        @FXML
        private TableColumn<Stickers, Integer> quantityColumn;  // Updated type to <Stickers, Integer>

        @FXML
        private AnchorPane root;

        @FXML
        private TableView<Stickers> stickersInformationTable;

        public StickerController() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/StickerCountView.fxml"));
                loader.setController(this);
                loader.load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            // Set up the columns to map to the Stickers model
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            // Load data into the table
            try {
                showPrintData();  // Call showPrintData to load the stickers data
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public AnchorPane getRoot() {
            return root;
        }

        private void showPrintData() throws IOException {
            Gson gson = new Gson();

            Path jsonFilePath = Paths.get(FILE_PATH);

            if (!Files.exists(jsonFilePath)) {
                throw new FileNotFoundException("The file " + FILE_PATH + " was not found");
            }

            // Read the JSON content
            String jsonContent = Files.readString(jsonFilePath);

            // Parse the JSON into a List of Stickers objects
            List<Stickers> stickerList = gson.fromJson(jsonContent, new TypeToken<List<Stickers>>() {}.getType());  // Updated type to List<Stickers>

            // Clear existing items from the table
            stickersInformationTable.getItems().clear();

            // Add all the Stickers objects to the TableView
            stickersInformationTable.getItems().addAll(stickerList);
        }
}
