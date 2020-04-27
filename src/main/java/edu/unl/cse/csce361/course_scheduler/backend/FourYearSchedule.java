package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.*;

public class FourYearSchedule extends Course {
        private String courseName;
        private String courseNumber;
        private static ArrayList<FourYearSchedule> schedule = new ArrayList<>();

        public FourYearSchedule(String courseName, String courseNumber){
            this.courseName = courseName;
            this.courseNumber = courseNumber;
            schedule.add(this);
        }

    public static Collection<FourYearSchedule> setAllCourses(Collection<Map<String, String>> courseList) {
            List<FourYearSchedule> courses = new ArrayList<>();
            for (Map<String,String> map : courseList) {
                courses.add(new FourYearSchedule(map.get("Name"),map.get("Course#")));
            }
        return courses;
    }

    public static void printSchedule(List<FourYearSchedule> optimalSchedule) {
            //TODO: Finish print schedule option
            System.out.println("This feature has not yet been implemented");
    }

    @Override
        public String getCourseName() {return courseName;}

        @Override
        public String getCourseNumber() {return courseNumber;}

        @Override
        public String toString() {
            return "Course Name: " + courseName + ", Course Number: " + courseNumber;
        }

    public static Collection<FourYearSchedule> setSchedule(Collection<Map<String, String>> scheduleList) {
        List<FourYearSchedule> schedules = new ArrayList<FourYearSchedule>();

        for (Map<String,String> map : scheduleList) {
            schedules.add(new FourYearSchedule(map.get("Course Name"),map.get("Course Number")));
        }
        return schedules;
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
