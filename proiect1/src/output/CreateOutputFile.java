package output;

import common.Constants;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class CreateOutputFile {
    public void createOutputFiles() throws IOException {
        File directory = new File("./output");

        if (!directory.exists()) {
            boolean result = directory.mkdirs();
            if (!result) {
                System.out.println("Error! Directory could not be created!");
            }
        } else if (Objects.requireNonNull(directory.list()).length == Constants.TESTS_NUMBER) {
            return;
        }

        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            String filename = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;

            File file = new File(filename);

            if (!file.exists()) {
                boolean result = file.createNewFile();
                if (!result) {
                    System.out.println("Error! File could not be created");
                }
            }
        }
    }
}
