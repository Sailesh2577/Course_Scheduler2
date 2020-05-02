package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.*;

public class Courses {
    private String name;
    private String departmentCode;
    private String courseNumber;

    public Courses(String name, String departmentCode, String courseNumber) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public String toString() {
        return name + " " + departmentCode + " " + courseNumber;
    }

    public static Collection<Courses> setAllCourses(Collection<Map<String, String>> courseList) {
        List<Courses> courses = new ArrayList<Courses>();

        for (Map<String,String> map : courseList) {
            courses.add(new Courses(map.get("Name"),map.get("Department Code"),map.get("Course Number")));
        }
        return courses;
    }

    public String toCsvFormat() {
        return (name + "," + departmentCode + "," + courseNumber);
    }
}
