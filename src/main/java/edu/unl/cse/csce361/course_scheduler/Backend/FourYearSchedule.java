package edu.unl.cse.csce361.course_scheduler.Backend;

import java.util.ArrayList;
import java.util.Iterator;

public class FourYearSchedule extends Courses {
    private String courseName;
    private String courseNumber;
    private static ArrayList<FourYearSchedule> schedule = new ArrayList<>();

    public FourYearSchedule(String courseName, String courseNumber){
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        schedule.add(this);
    }

    @Override
    public String getCourseName() {return courseName;}

    @Override
    public String getCourseNumber() {return courseNumber;}

    @Override
    public String toString() {
        return "Course Name: " + courseName + ", Course Number: " + courseNumber;
    }

    public static FourYearSchedule getSchedule(String courseNumber) {
        FourYearSchedule course = null;
        if(schedule.size() == 0) {
            return course;
        }
        Iterator<FourYearSchedule> iterator = schedule.iterator();
        while(iterator.hasNext()) {
            FourYearSchedule currentSchedule = iterator.next();
            if(currentSchedule.getCourseNumber().equals(courseNumber)) {
                course = currentSchedule;
            }
        }

        return course;
    }
}
