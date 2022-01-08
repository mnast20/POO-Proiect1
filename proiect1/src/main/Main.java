package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import database.SantaDatabase;
import input.Input;
import output.CreateOutputFile;
import output.Output;
import round.Round;

import java.io.File;
import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for Main
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        // create output files if they weren't created
        new CreateOutputFile().createOutputFiles();

        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            // input and output files name strings
            String inputFilename = "./tests/test" + i + Constants.FILE_EXTENSION;
            String outputFilename = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;

            // input and output files
            File fileInput = new File(inputFilename);
            File fileOutput = new File(outputFilename);

            // read input data from the input JSON file
            Input input = objectMapper.readValue(fileInput, Input.class);
            // add input data to Santa Database
            SantaDatabase.getSantaDatabase().addDataFromInput(input);

            // get output
            Output output = new Round().solveRounds(input.getAnnualChanges());
            // write output data from the output JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileOutput, output);

            // clear Santa Database
            SantaDatabase.getSantaDatabase().clear();
        }

        // check output
        Checker.calculateScore();
    }
}
