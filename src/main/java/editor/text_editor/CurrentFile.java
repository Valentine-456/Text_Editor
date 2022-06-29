package editor.text_editor;

import java.io.File;

public class CurrentFile {
    private static String filePath = null;
    private static String fileName = null;

    public static String getFilePath() {
        return filePath;
    }
    public static String getFileName() {
        return fileName;
    }
    public static void setNewFile(String pathToFile) {
        filePath = pathToFile;
        if(filePath == null) fileName = null;
        else {
            File file = new File(filePath);
            fileName = file.getName();
        }
    }
    public static void clearCurrentFile() {
        setNewFile(null);
    }
}
