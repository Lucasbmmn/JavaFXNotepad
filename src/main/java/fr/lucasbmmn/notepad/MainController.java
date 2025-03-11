package fr.lucasbmmn.notepad;

import fr.lucasbmmn.notepad.utils.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ResourceBundle;

/**
 * Main controller class for the Notepad application.
 * Handles user interactions and file operations.
 */
public class MainController {
    @FXML
    private TextArea textArea; // The main text area where users input and edit text
    @FXML
    private Label posLabel; // Label to display the cursor position
    @FXML
    private Label characterLabel; // Label to display character count
    @FXML
    private Label encodingLabel; // Label to display the file encoding
    private Stage stage; // The main application window
    private ResourceBundle i18nBundle; // Resource bundle for internationalization
    private String fileName = ""; // The name of the currently open file
    private String filePath = ""; // The path of the currently open file
    private boolean isFileSaved = false; // Flag to check if the file is saved

    /**
     * Creates a new file. Prompts the user to save the current file if it has unsaved changes.
     */
    @FXML
    private void actionNew() {
        if (this.isFileSaved || this.textArea.getText().isEmpty() || this.askSave()) {
            this.textArea.clear();
            this.fileName = "";
            this.filePath = "";
            this.isFileSaved = false;
        }
    }

    /**
     * Opens an existing file. Prompts the user to save the current file if it has unsaved changes.
     */
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

    /**
     * Saves the current file. If the file has not been saved before, it calls actionSaveAs().
     */
    @FXML
    private void actionSave() {
        if (!this.filePath.isEmpty()) FileHandler.saveFile(this.filePath, this.textArea.getText());
        else actionSaveAs();
        this.isFileSaved = true;
    }

    /**
     * Saves the current file as a new file. Prompts the user to choose a file name and location.
     */
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

    /**
     * Undoes the last text action (addition or deletion) performed in the text area.
     */
    @FXML
    private void actionUndo() {
        this.textArea.undo();
    }

    /**
     * Redoes the last undone text action (addition or deletion) in the text area.
     */
    @FXML
    private void actionRedo() {
        this.textArea.redo();
    }


    /**
     * Cuts the selected text and copies it to the clipboard.
     */
    @FXML
    private void actionCut() {
        this.textArea.cut();
    }

    /**
     * Copies the selected text to the clipboard.
     */
    @FXML
    private void actionCopy() {
        this.textArea.copy();
    }

    /**
     * Pastes the text from the clipboard into the text area.
     */
    @FXML
    private void actionPaste() {
        this.textArea.paste();
    }

    /**
     * Deletes the selected text from the text area.
     */
    @FXML
    private void actionDelete() {
        this.textArea.deleteNextChar();
    }

    /**
     * Prompts the user to save the current file if it has unsaved changes.
     *
     * @return true if the user chooses to save or discard the changes, false if the user cancels
     */
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

    /**
     * Sets the stage for the application.
     *
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Sets the internationalization resource bundle.
     *
     * @param i18nBundle the resource bundle to set
     */
    public void setI18nBundle(ResourceBundle i18nBundle) {
        this.i18nBundle = i18nBundle;
    }
}
