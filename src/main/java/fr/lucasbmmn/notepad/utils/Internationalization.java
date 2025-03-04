package fr.lucasbmmn.notepad.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Utility class for handling internationalization.
 */
public class Internationalization {
    private Locale locale;
    private ResourceBundle bundle;

    /**
     * Initializes the internationalization settings with the default locale.
     */
    public Internationalization() {
        locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("fr/lucasbmmn/notepad/languages/language", this.locale);
    }

    /**
     * Returns the resource bundle for the current locale.
     *
     * @return the resource bundle
     */
    public ResourceBundle getBundle() {
        return bundle;
    }
}
