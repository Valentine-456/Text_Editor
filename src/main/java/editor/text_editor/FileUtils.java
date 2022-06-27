package editor.text_editor;

import java.io.*;

public class FileUtils {

    public static String readFile(String pathToFile) {
        StringBuilder data = new StringBuilder();
        data.append("<html dir=\"ltr\"><head>" +
                "<style>" +
                "p {" +
                "margin: 0;" +
                "}" +
                "</style></head><body contenteditable=\"true\">");
        try {
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line = "";

        while ((line = reader.readLine()) != null) {
            data.append(line + "<p><br></p>");
        }
        reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        data.append("</body></html>");
        return data.toString();
    }
    public static void writeToFile(String pathToFile, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile));
            data = data.substring(124, (data.length() - 14));
            data = data.replaceAll("<p><br></p>", "\n");

            writer.write(data);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
