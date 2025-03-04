package fr.lucasbmmn.notepad.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class for handling file operations.
 */
public class FileHandler {
    /**
     * Saves the content to the specified file path.
     *
     * @param filePath the path of the file to save
     * @param content the content to write to the file
     */
    public static void saveFile(String filePath, String content) {
        saveFile(new File(filePath), content);
    }

    /**
     * Saves the content to the specified file.
     *
     * @param file the file to save
     * @param content the content to write to the file
     */
    public static void saveFile(File file, String content) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Opens the file at the specified file path and returns its content.
     *
     * @param filePath the path of the file to open
     * @return the content of the file
     */
    public static String openFile(String filePath) {
        return openFile(new File(filePath));
    }

    /**
     * Opens the specified file and returns its content.
     *
     * @param file the file to open
     * @return the content of the file
     */
    public static String openFile(File file) {
        try {
            StringBuilder result = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine());
                result.append('\n');
            }
            scanner.close();
            return result.substring(0, result.length());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
