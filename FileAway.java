import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab_12_File_Away {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                java.io.File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName();
              BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                int linesCount = 0;
                int wordsCount = 0;
                int charactersCount = 0;

                while ((line = reader.readLine()) != null) {
                    linesCount++;
                    wordsCount += line.split("\\s+").length;
                    charactersCount += line.length();
                }
                reader.close();
                System.out.println("File Name: " + fileName);
                System.out.println("Number of Lines: " + linesCount);
                System.out.println("Number of Words: " + wordsCount);
                System.out.println("Number of Characters: " + charactersCount);
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file chosen.");
        }
    }
}
