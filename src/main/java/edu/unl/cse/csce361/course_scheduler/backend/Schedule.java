package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.ArrayList;
import java.util.Map;

public class Schedule {
    //List of Maps that are String, Courses pair in which the string is the Semester and Courses is the course they
    //plan to take
    private static ArrayList<Map<String, Courses>> schedule = new ArrayList<>();

    public void addCourse(Map<String, Courses> course) {
        schedule.add(course);
    }

    public void deleteCourse(Map<String, Courses> course) {
        schedule.remove(course);
    }

    public ArrayList<Map<String, Courses>> getSchedule() {
        return schedule;
    }

}
