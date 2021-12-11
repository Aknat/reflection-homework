package annotationsForSaving;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "Awesome.txt")
public class TextContainer {
    public String text = "Annotations broke my brain!";

    @Save
    public void saveToFile(String pathToFile, String text) {
        File file = new File(pathToFile);
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.println(text);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
