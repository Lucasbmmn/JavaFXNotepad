module fr.lucasbmmn.notepad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.lucasbmmn.notepad to javafx.fxml;
    exports fr.lucasbmmn.notepad;
}