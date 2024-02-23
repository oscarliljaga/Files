import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages reading/writing from/to a saved file
 */
public class SavedFile {
    // Attributes
    String fileName;
    File myFile;

    //Constructor
    public SavedFile(String fileName) {
        this.fileName = fileName;
        myFile = new File(fileName);

        //Tries to create file, might already exist
        try {
            myFile.createNewFile();
            this.Write("", true);
        } catch (IOException e) {
            System.out.println("File could not be created...");
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
    }

    //Read from file
    public ArrayList<String> Read() {
        ArrayList<String> output = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                output.add(scanner.nextLine());
            }
            return output;
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist...");
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
        return null;
    }

    //Write to file
    public void Write(String input, Boolean append) {
        try {
            FileWriter myFileWriter = new FileWriter(myFile, append);
            myFileWriter.write(input);
            myFileWriter.close();
            System.out.println("File saved!");
        } catch (IOException e) {
            System.out.println("FileWriter could not be created...");
        }
    }
}