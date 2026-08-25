import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    private static int unprocessedcount = 0;
    private static int countA = 0;
    private static int countB = 0;
    private static int countC = 0;
    private static int countD = 0;
    private static int countF = 0;
    private static String outputfile = "report.txt";

    public static void main(String[] args) {
        String filename = "scores.txt";
        ArrayList<Integer> scoreList = readScores(filename);
        int maxscore = Integer.MAX_VALUE;
        int minscore = Integer.MIN_VALUE;
        for (int score : scoreList) {
            if (score < minscore) {
                minscore = score;
            } else if (score > maxscore) {
                maxscore = score;
            }
            if (90 <= score) {
                countA++;
            } else if (80 <= score) {
                countB++;
            } else if (70 <= score) {
                countC++;
            } else if (60 <= score) {
                countD++;
            } else {
                countF++;
            }
        }
        writeReport(scoreList, calculateAverage(scoreList), maxscore, minscore, outputfile);

        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while (((line = reader.readLine()) != null)) {
                if (line.isEmpty()) {
                    unprocessedcount++;
                    continue;
                }
                try {
                    int currentscore = Integer.parseInt(line.trim());
                    scores.add(currentscore);
                } catch (NumberFormatException e) {
                    System.out.println("WARNING: NumberFormatException");
                    unprocessedcount++;
                }
            }
        } catch (IOException e) {
            System.out.println("WARNING: IOException");
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < scores.size(); i++) {
            sum = sum + scores.get(i);
        }
        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile))) {
            writer.write(String.format("=== Grade Analysis Report ==="));
            writer.newLine();
            writer.write(String.format("Total scores processed: " + scores.size()));
            writer.newLine();
            writer.write(String.format("Invalid lines skipped: " + unprocessedcount));
            writer.newLine();
            writer.newLine();
            writer.write(String.format("Average score: " + avg));
            writer.newLine();
            writer.write(String.format("Highest score: " + high));
            writer.newLine();
            writer.write(String.format("Lowest score: " + low));
            writer.newLine();
            writer.newLine();
            writer.write(String.format("Grade Distribution:"));
            writer.newLine();
            writer.write(String.format("A (90-100): " + countA));
            writer.newLine();
            writer.write(String.format("B (80-89): " + countB));
            writer.newLine();
            writer.write(String.format(" C (70-79): " + countC));
            writer.newLine();
            writer.write(String.format("D (60-69): " + countD));
            writer.newLine();
            writer.write(String.format("F (below 60): " + countF));

            System.out.println(String.format("=== Grade Analysis Report ==="));
            System.out.println(String.format("Total scores processed: %d", scores.size()));
            System.out.println(String.format("Invalid lines skipped: " + unprocessedcount));
            System.out.println(String.format("Average score: " + avg));
            System.out.println(String.format("Highest score: " + high));
            System.out.println(String.format("Lowest score: %d", low));
            System.out.println(String.format("Grade Distribution:"));
            System.out.println(String.format("A (90-100): " + countA));
            System.out.println(String.format("B (80-89): " + countB));
            System.out.println(String.format("C (70-79): %d", countC));
            System.out.println(String.format("D (60-69): " + countB));
            System.out.println(String.format("F (below 60): " + countF));


        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}