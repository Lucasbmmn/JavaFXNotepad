package fr.lucasbmmn.notepad;

import fr.lucasbmmn.notepad.utils.Internationalization;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Internationalization
        Internationalization i18n = new Internationalization();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-view.fxml"));
        fxmlLoader.setResources(i18n.getBundle()); // Internationalization in fxml
        Scene scene = new Scene(fxmlLoader.load(), 1000, 500);
        MainController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setI18nBundle(i18n.getBundle());

        stage.setTitle(i18n.getBundle().getString("app.title") + " - " + i18n.getBundle().getString("app.file.untitled"));
        stage.setMinWidth(250);
        stage.setMinHeight(150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}