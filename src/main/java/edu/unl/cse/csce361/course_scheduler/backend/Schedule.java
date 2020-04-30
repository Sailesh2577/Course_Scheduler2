package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    //List of Maps that are String, Courses pair in which the string is the Semester and Courses is the course they
    //plan to take
    private static ArrayList<Map<String, Courses>> schedule = new ArrayList<>();

    public void addCourse(String semester, Courses course) {
        Map<String, Courses> semesterCourse = new HashMap<>();
        semesterCourse.put(semester, course);
        schedule.add(semesterCourse);
    }

    public void deleteCourse(String semester, Courses course) {
        Map<String, Courses> semesterCourse = new HashMap<>();
        semesterCourse.put(semester, course);
        schedule.remove(semesterCourse);
    }

    public ArrayList<Map<String, Courses>> getSchedule() {
        return schedule;
    }

}
