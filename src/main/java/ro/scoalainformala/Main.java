package ro.scoalainformala;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL to read from:");
        String urlString = scanner.nextLine();

        System.out.println("Enter the file path to save to:");
        String filePath = scanner.nextLine();

        try {
            URL url = new URL(urlString);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    int wordCount = inputLine.split("\\s+").length;
                    writer.write(wordCount + " " + inputLine);
                    writer.newLine();
                }

                System.out.println("File written to " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}