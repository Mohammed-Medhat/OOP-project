import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\Customer.txt";

        // Writing to file
        List<String> contentListToWrite = new ArrayList<>();
        contentListToWrite.add("Line 11");
        contentListToWrite.add("Line 2");
        contentListToWrite.add("Line 3");

        Files.writeFile(filePath, contentListToWrite);
        System.out.println("Content has been written to the file successfully!");

        // Reading from file
        List<String> contentListRead = Files.readFileToList(filePath);

        System.out.println("File Content as List:");
        for (String line : contentListRead) {
            System.out.println(line);
        }
    }
}


