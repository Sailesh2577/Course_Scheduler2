package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.*;

public class Schedule {
    //List of Maps that are String, Courses pair in which the string is the Semester and Courses is the course they
    //plan to take
    private static ArrayList<Map<String, Courses>> schedule = new ArrayList<>();

    //String semester should be in the format of "Semester #"
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

    //Prints out the maps in the list in the format of "Semester # = Course"
    public void printSchedule() {
        Iterator<Map<String, Courses>> iterator = schedule.iterator();
        while(iterator.hasNext()) {
            Map<String, Courses> course = iterator.next();
            System.out.println(course.toString());
        }
    }



}
