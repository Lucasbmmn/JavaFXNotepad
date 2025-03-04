package fr.lucasbmmn.notepad.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    public static void saveFile(String filePath, String content) {
        saveFile(new File(filePath), content);
    }

    public static void saveFile(File file, String content) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String openFile(String filePath) {
        return openFile(new File(filePath));
    }

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
