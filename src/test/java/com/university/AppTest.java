package com.university;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.university.primeraParte.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AppTest {
    @BeforeEach
    public void deleteSolutions(){
        File file1 = new File("src/main/resources/solution.csv");
        file1.delete();
        File file2 = new File("src/main/resources/solution_2.csv");
        file2.delete();
    }
    @Test
    public void testSolutionCSVMatchesExpected() {

        String solutionFilePath = "src/main/resources/solution.csv";
        String expectedFilePath = "src/main/resources/expected.csv";

        // Check if solution.csv exists before running the test
        if (Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution.csv file exists before the test runs.");
        }

        try {
            App.main(new String[]{});  // Running the App's main method
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute App.main()");
        }

        // Check if solution.csv was created after running the test
        if (!Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution.csv file does not exist after running the test.");
        }

        // Proceed to compare the solution.csv with expected.csv
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(solutionFilePath));
             BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath))) {

            String solutionLine;
            String expectedLine;

            while ((solutionLine = solutionReader.readLine()) != null &&
                   (expectedLine = expectedReader.readLine()) != null) {
                assertEquals(expectedLine, solutionLine, "Mismatch found in the CSV file content.");
            }

            // Ensure both files have the same number of lines
            assertEquals(solutionReader.readLine(), expectedReader.readLine(), "Files have different number of lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSolution_2CSVMatchesExpected(){
        String solutionFilePath = "src/main/resources/solution_2.csv";
        String expectedFilePath = "src/main/resources/expected_2.csv";

        // Check if solution.csv exists before running the test
        if (Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution_2.csv file exists before the test runs.");
        }

        try {
            App.main(new String[]{});  // Running the App's main method
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute App.main()");
        }

        // Check if solution.csv was created after running the test
        if (!Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution_2.csv file does not exist after running the test.");
        }

        // Proceed to compare the solution.csv with expected.csv
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(solutionFilePath));
             BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath))) {

            String solutionLine;
            String expectedLine;

            while ((solutionLine = solutionReader.readLine()) != null &&
                    (expectedLine = expectedReader.readLine()) != null) {
                if(!expectedLine.contains("Geography,TP3")) {
                    assertEquals(expectedLine, solutionLine, "Mismatch found in the CSV file content.");
               }
            }

            // Ensure both files have the same number of lines
            assertEquals(solutionReader.readLine(), expectedReader.readLine(), "Files have different number of lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
