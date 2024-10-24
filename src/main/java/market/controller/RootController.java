package market.controller;

import javafx.fxml.FXMLLoader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import tab.controller.PrintsController;
import tab.controller.StickerController;
import tab.controller.TransactionController;

public class RootController implements Initializable {

        @FXML
        private TabPane editionTabPane;

        @FXML
        private AnchorPane root;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootControllerView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // borra las pestañas default
        editionTabPane.getTabs().clear();

        Tab transactionTab = new Tab("Transactions");
        transactionTab.setContent(new TransactionController().getRoot());

        Tab printsTab = new Tab("Prints");
        printsTab.setContent(new PrintsController().getRoot());

        Tab scoreBoardTab = new Tab("Stickers");
        scoreBoardTab.setContent(new StickerController().getRoot());

        editionTabPane.getTabs().addAll(transactionTab, printsTab, scoreBoardTab);
    }

    public AnchorPane getRoot() {
        return root;
    }


}
