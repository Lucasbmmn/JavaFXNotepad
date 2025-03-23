package fr.lucasbmmn.notepad.utils;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Utility class for handling internationalization.
 */
public class Internationalization {
    private final NumberFormat numberFormat; // Number format for displaying numeric values
    private final ResourceBundle bundle; // Resource bundle for internationalization

    /**
     * Initializes the internationalization settings with the default locale.
     */
    public Internationalization() {
        Locale locale = Locale.getDefault(); // Default locale for the application
        numberFormat = NumberFormat.getInstance(locale);
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

    /**
     * Returns the number format for the current locale.
     *
     * @return the number format
     */
    public NumberFormat getNumberFormat() {
        return numberFormat;
    }
}
