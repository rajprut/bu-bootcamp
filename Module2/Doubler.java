import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Doubler {
    public static void main(String[] args) {
        String filename = "numbers.txt";
        String outputfile = "doubleoutput.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int currentcount = Integer.parseInt(line.trim());
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile))) {
                    writer.write(String.valueOf(currentcount) + " " + String.valueOf(currentcount*2));
                    System.out.println(String.valueOf(currentcount) + " " + String.valueOf(currentcount*2));
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("Could not write file: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}
