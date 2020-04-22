package edu.unl.cse.csce361.course_scheduler.backend;

import java.io.*;
import java.util.*;

public class CsvReader {

    public Collection<Map<String, String>> readFile(String filename) {
        List<Map<String, String>> csvList = new ArrayList<>();
        String readLine;
        List<String> keys = new ArrayList<>();
        boolean keyLineRead = false;


        try {
            BufferedReader buff = new BufferedReader(new FileReader(filename));
            while ((readLine = buff.readLine()) != null) {
                Map<String, String> map = new HashMap<>();
                String[] row = readLine.split(",");

                if (!keyLineRead) {
                    keys = Arrays.asList(row);
                    keyLineRead = true;
                } else {
                    for (int i = 0; i < 3; ++i) {
                        map.put(keys.get(i), row[i]);
                    }
                    csvList.add(map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvList;
    }
}
