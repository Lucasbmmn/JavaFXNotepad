module fr.lucasbmmn.notepad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.lucasbmmn.notepad to javafx.fxml;
    exports fr.lucasbmmn.notepad;
    exports fr.lucasbmmn.notepad.utils;
    opens fr.lucasbmmn.notepad.utils to javafx.fxml;
}