package fr.lucasbmmn.notepad.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {
    private Locale locale;
    private ResourceBundle bundle;

    public Internationalization() {
        locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("fr/lucasbmmn/notepad/languages/language", this.locale);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }
}
