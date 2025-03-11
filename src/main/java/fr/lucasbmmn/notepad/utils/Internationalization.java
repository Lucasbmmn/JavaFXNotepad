package fr.lucasbmmn.notepad.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Utility class for handling internationalization.
 */
public class Internationalization {
    private final ResourceBundle bundle; // Resource bundle for internationalization

    /**
     * Initializes the internationalization settings with the default locale.
     */
    public Internationalization() {
        Locale locale = Locale.getDefault(); // Default locale for the application
        bundle = ResourceBundle.getBundle("fr/lucasbmmn/notepad/languages/language", locale);
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
