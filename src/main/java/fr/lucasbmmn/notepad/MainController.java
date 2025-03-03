package fr.lucasbmmn.notepad;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainController {
    @FXML
    private TextArea textArea;
    @FXML
    private Label posLabel;
    @FXML
    private Label characterLabel;
    @FXML
    private Label encodingLabel;

    @FXML
    private void actionNew() {

    }

    @FXML
    private void actionOpen() {

    }

    @FXML
    private void actionSave() {

    }

    @FXML
    private void actionSaveAs() {

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
        this.textArea.deleteText(this.textArea.getSelection());
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

    }
}