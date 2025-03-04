package fr.lucasbmmn.notepad;

import fr.lucasbmmn.notepad.utils.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class MainController {
    @FXML
    private TextArea textArea;
    @FXML
    private Label posLabel;
    @FXML
    private Label characterLabel;
    @FXML
    private Label encodingLabel;
    private Stage stage;
    private ResourceBundle i18nBundle;
    private String filePath = "";

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setI18nBundle(ResourceBundle i18nBundle) {
        this.i18nBundle = i18nBundle;
    }

    @FXML
    private void actionNew() {

    }

    @FXML
    private void actionOpen() {

    }

    @FXML
    private void actionSave() {
        if (!this.filePath.isEmpty()) FileHandler.saveFile(this.filePath, this.textArea.getText());
        else actionSaveAs();
    }

    @FXML
    private void actionSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(i18nBundle.getString("app.dialog_box.save_as"));
        fileChooser.setInitialFileName(i18nBundle.getString("app.file.untitled"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(i18nBundle.getString("app.dialog_box.extension.all_files"),
                        "*.txt"),
                new FileChooser.ExtensionFilter(i18nBundle.getString("app.dialog_box.extension.text_files"),
                        "*.*")
        );
        File file = fileChooser.showSaveDialog(this.stage);
        FileHandler.saveFile(file, this.textArea.getText());
        this.filePath = file.getPath();
    }

    @FXML
    private void actionSettings() {

    }

    @FXML
    private void actionQuit() {

    }

    @FXML
    private void actionUndo() {

    }

    @FXML
    private void actionRedo() {

    }

    @FXML
    private void actionCut() {
        actionCopy();
        actionDelete();
    }

    @FXML
    private void actionCopy() {
        StringSelection selection = new StringSelection(this.textArea.getSelectedText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
    }

    @FXML
    private void actionPaste() throws IOException, UnsupportedFlavorException {
        this.textArea.replaceSelection((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
    }

    @FXML
    private void actionDelete() {
        this.textArea.deleteText(this.textArea.getSelection());
    }
}