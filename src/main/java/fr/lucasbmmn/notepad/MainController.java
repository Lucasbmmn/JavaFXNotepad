package fr.lucasbmmn.notepad;

import fr.lucasbmmn.notepad.utils.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    private String fileName = "";
    private String filePath = "";
    private boolean isFileSaved = false;

    @FXML
    private void actionNew() {
        if (this.isFileSaved || this.textArea.getText().isEmpty() || this.askSave()) {
            this.textArea.clear();
            this.fileName = "";
            this.filePath = "";
            this.isFileSaved = false;
        }
    }

    @FXML
    private void actionOpen() {
        if (this.isFileSaved || this.textArea.getText().isEmpty() || this.askSave()) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter(i18nBundle.getString("app.dialog_box.extension.all_files"),
                            "*.txt"),
                    new FileChooser.ExtensionFilter(i18nBundle.getString("app.dialog_box.extension.text_files"),
                            "*.*")
            );
            File file = fileChooser.showOpenDialog(this.stage);
            if (file != null) {
                this.textArea.setText(FileHandler.openFile(file));
                this.fileName = file.getName();
                this.filePath = file.getPath();
                this.isFileSaved = true;
            }
        }
    }

    @FXML
    private void actionSave() {
        if (!this.filePath.isEmpty()) FileHandler.saveFile(this.filePath, this.textArea.getText());
        else actionSaveAs();
        this.isFileSaved = true;
    }

    @FXML
    private void actionSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(fileName.isEmpty() ?
                i18nBundle.getString("app.file.untitled") : fileName);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(i18nBundle.getString("app.dialog_box.extension.all_files"),
                        "*.txt"),
                new FileChooser.ExtensionFilter(i18nBundle.getString("app.dialog_box.extension.text_files"),
                        "*.*")
        );
        File file = fileChooser.showSaveDialog(this.stage);
        if (file != null) {
            FileHandler.saveFile(file, this.textArea.getText());
            this.fileName = file.getName();
            this.filePath = file.getPath();
            this.isFileSaved = true;
        }
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

    private boolean askSave() {
        boolean result = true;

        Alert alert = new Alert(
                Alert.AlertType.WARNING,
                String.format(
                        i18nBundle.getString("app.dialog_box.warning.file_not_saved.message"),
                        this.fileName.isEmpty() ?
                                i18nBundle.getString("app.file.untitled") : this.fileName
                ),
                ButtonType.YES, ButtonType.NO, ButtonType.CANCEL
        );

        alert.setTitle(i18nBundle.getString("app.dialog_box.warning.file_not_saved.title"));
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) this.actionSave();
        else if (alert.getResult() == ButtonType.CANCEL) result = false;

        return result;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setI18nBundle(ResourceBundle i18nBundle) {
        this.i18nBundle = i18nBundle;
    }
}