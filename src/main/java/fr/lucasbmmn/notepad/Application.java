package fr.lucasbmmn.notepad;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Application extends javafx.application.Application {
    private Locale locale;
    private ResourceBundle bundle;

    @Override
    public void start(Stage stage) throws IOException {
        // Internationalization
        locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("fr/lucasbmmn/notepad/languages/language", this.locale);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-view.fxml"));
        fxmlLoader.setResources(bundle); // Internationalization in fxml
        Scene scene = new Scene(fxmlLoader.load(), 1000, 500);

        stage.setTitle(bundle.getString("app.title"));
        stage.setMinWidth(250);
        stage.setMinHeight(150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}