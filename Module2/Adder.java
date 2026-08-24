import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class Adder {
    public static void main(String[] args) {
        String filename = "numbers.txt";
        String outputfile = "output.txt";
        int finalcount = 0;
 
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                int currentcount = Integer.parseInt(line.trim());
                finalcount = finalcount + currentcount;
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        System.out.println("finalcount:" + finalcount);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile))) {
            writer.write(String.valueOf(finalcount));
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
} 