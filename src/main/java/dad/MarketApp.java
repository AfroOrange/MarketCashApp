package dad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import market.controller.RootController;

import java.util.Objects;

public class MarketApp extends Application {

    private final RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene hangmanScene = new Scene(rootController.getRoot());

        Stage hangmanStage = new Stage();
        //Image appIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/9.png")).toString());

        //hangmanStage.getIcons().add(appIcon);
        hangmanStage.setTitle("Market App");
        hangmanStage.setScene(hangmanScene);
        hangmanStage.show();
    }
}
