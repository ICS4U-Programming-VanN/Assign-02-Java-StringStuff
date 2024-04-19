/**
* This program finds the max run of the strings in an input file
*
* @author  Van Nguyen
* @version 1.0
* @since   2024-04-10
*/

import java.io.*;
import java.util.*;

public class StringStuff {
  // Max Run finding run function
  public static int maxRun(final char[] input, ArrayList<Character> maxRunCharacters) {
    // Initialize Variables
    // Start at 1 because we count the current character itself
    int currentRun = 1;
    int highestRun = 1;

    // Loops through string to find the max run
    for (int index = 0; index < input.length - 1; index++) {
        // If the current character is the same as the next
        if (input[index] == input[index + 1]) {
            currentRun++;

            // If the current run is higher than the highest run
            if (currentRun > highestRun) {
                highestRun = currentRun;
                // Clear previous characters and adds the new highest run
                maxRunCharacters.clear();
                maxRunCharacters.add(input[index]);
            } else if (currentRun == highestRun) {
                // If current run equals highest run, add the character
                maxRunCharacters.add(input[index]);
            }
        } else {
            // Reset the current run count
            currentRun = 1;
        }
    }
    return highestRun;
}
    public static void main(String[] args) throws FileNotFoundException {
        // Try Catch
        try {
            // File paths
            String in = "./input.txt";
            String out = "./output.txt";
            File input = new File(in);
            File output = new File(out);

            // Scanner + Writer
            Scanner scanner = new Scanner(input);
            FileWriter writer = new FileWriter(output);

            // Initialize Variable
            String fileLine;
            int maxRun;

            // To store the max run characters
            ArrayList<Character> maxRunCharacters = new ArrayList<>();

            // Input from input file
            while (scanner.hasNextLine()) {
                // Reading line
                fileLine = scanner.nextLine();
                
                // Skip processing if the line is blank
                if (fileLine.trim().isEmpty()) {
                    continue;
                }

                // Calls maxRun function
                maxRun = maxRun(fileLine.toCharArray(), maxRunCharacters);

                // Writing the output to output file
                writer.write("The max run is " + maxRun + " for character(s): " + maxRunCharacters + "\n");

                // Prints output to console
                System.out.println("The max run is " + maxRun + " for character(s): " + maxRunCharacters + "\n");

                // Clear the list for the next iteration
                maxRunCharacters.clear();
            }

            // Closes writer and scanner
            scanner.close();
            writer.close();

        } catch (IOException e) {
            System.out.println("File could not be found. Please fix the file path.");
        }
    }
}
