package fr.lucasbmmn.notepad.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static void saveFile(String filePath, String content) {
        saveFile(new File(filePath), content);
    }

    public static void saveFile(File file, String content) {
        if (file != null){
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(content);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String openFile(String filePath) {
        return openFile(new File(filePath));
    }

    public static String openFile(File file) {
        return "";
    }
}
