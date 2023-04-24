import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Fileaway {
    public static void main(String[] args) {
        // Create a JFileChooser object to open a file dialog
        JFileChooser fileChooser = new JFileChooser();
        
        // Show the file chooser dialog and store the return value
        int returnValue = fileChooser.showOpenDialog(null);
        
        // Check if the user selected a file
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            
            // Initialize counters for lines, words, and characters
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            
            // Use a try-with-resources block to read the file with a BufferedReader
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                
                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    // Increment the line counter
                    lineCount++;
                    
                    // Split the line into words and increment the word counter
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                    
                    // Increment the character counter
                    charCount += line.length();
                }
            } catch (IOException e) {
                // Handle any exceptions that occur while reading the file
                e.printStackTrace();
            }
            
            // Print the summary report to the console
            System.out.println("Summary Report:");
            System.out.println("File: " + selectedFile.getName());
            System.out.println("Number of lines: " + lineCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of characters: " + charCount);
        }
    }
}
