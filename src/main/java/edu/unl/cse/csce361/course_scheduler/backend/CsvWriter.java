package edu.unl.cse.csce361.course_scheduler.backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public void writeToFile(String fileName, String csvLine) {
        fileName = "src/main/resources/csv/" + fileName;

        try {
            FileWriter filewriter = new FileWriter(fileName, true);
            BufferedWriter out = new BufferedWriter(filewriter);
            out.append("\n" + csvLine);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
