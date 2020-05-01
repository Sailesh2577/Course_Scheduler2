package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class Course {
    private String courseName;
    private String courseNumber;
    private static ArrayList<Course> courses = new ArrayList<>();

    //Constructor
    public Course(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        courses.add(this);
    }

    public static Collection<Course> setAllCourses(Collection<Map<String, String>> courseList) {
        List<Course> courses = new ArrayList<Course>();

        for (Map<String,String> map : courseList) {
            courses.add(new Course(map.get("Name"), map.get("Course#")) {
            });
        }
        return courses;
    }

    public abstract String getCourseName(){ };
    public abstract String getCourseNumber(){ }

}
