package output;

import common.Constants;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class CreateOutputFile {
    /**
     * Method creating the output folder and files if they are nonexistent
     */
    public void createOutputFiles() throws IOException {
        File directory = new File("./output");

        // check if directory exists
        if (!directory.exists()) {
            // create directory
            boolean result = directory.mkdirs();
            // check if directory was created successfully
            if (!result) {
                System.out.println("Error! Directory could not be created!");
            }
        } else if (Objects.requireNonNull(directory.list()).length == Constants.TESTS_NUMBER) {
            // directory has in total 25 files, as it should
            return;
        }

        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            // output file name string
            String filename = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;

            File file = new File(filename);

            // check if file exists
            if (!file.exists()) {
                // create file
                boolean result = file.createNewFile();
                // check if file was created successfully
                if (!result) {
                    System.out.println("Error! File could not be created");
                }
            }
        }
    }
}
