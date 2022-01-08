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
        new CreateOutputFile().createOutputFiles();

        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            String inputFilename = "./tests/test" + i + Constants.FILE_EXTENSION;
            String outputFilename = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;

            File fileInput = new File(inputFilename);
            File fileOutput = new File(outputFilename);

            Input input = objectMapper.readValue(fileInput, Input.class);
            SantaDatabase.getSantaDatabase().addDataFromInput(input);

            Output output = new Round().solveRounds(input.getAnnualChanges());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileOutput, output);

            SantaDatabase.getSantaDatabase().clear();
        }

        Checker.calculateScore();
    }
}
