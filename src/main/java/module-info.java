module fr.lucasbmmn.notepad {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.lucasbmmn.notepad to javafx.fxml;
    exports fr.lucasbmmn.notepad;
}