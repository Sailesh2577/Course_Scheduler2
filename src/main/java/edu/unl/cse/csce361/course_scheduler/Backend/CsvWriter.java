package edu.unl.cse.csce361.course_scheduler.Backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public void writeToFile(String fileName, Student student) {
        fileName = "src/main/resources/csv/" + fileName;

        try {
            FileWriter filewriter = new FileWriter(fileName, true);
            BufferedWriter out = new BufferedWriter(filewriter);
            String name = student.getName();
            String id = student.getId();
            String gradeLevel = student.getGradeLevel();
            String newLine = name + "," + id + "," + gradeLevel;
            out.append("\n" + newLine);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
