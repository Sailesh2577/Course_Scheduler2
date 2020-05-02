package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.*;

public class Schedule {
    //List of Maps that are String, Courses pair in which the string is the Semester and Courses is the course they
    //plan to take
    private static ArrayList<Map<String, Courses>> schedule;

    public Schedule() {
        schedule = new ArrayList<>();
    }

    public Schedule(Collection<Map<String, String>> studentCourses) {
        for (Map<String,String> map : studentCourses) {
            Courses course = new Courses(map.get("Name"),map.get("Department Code"),map.get("Course Number"));
            Map addMap = new HashMap();
            addMap.put(map.get("Semester"),course);
            schedule.add(addMap);
        }
    }
    //String semester should be in the format of "Semester #"
    public static void addCourse(String semester, Courses course) {
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

    //Prints out the schedule in terms of semester and which classes are currently being requested in each semester
    public void printSchedule() {
        System.out.println();

        ArrayList<Map<String, Courses>> studentSchedule = getSchedule();

        for(int i = 0; i < 8; i++) {
            System.out.println("Semester " + (i + 1) + ": ");
            Iterator<Map<String, Courses>> iterator = studentSchedule.iterator();
            while(iterator.hasNext()) {
                Map<String, Courses> course = iterator.next();
                if(course.get("Semester " + (i + 1)) != null) {
                    System.out.println(course.get("Semester " + (i + 1)));
                }
            }

        }
    }


    public String getNextSemester() {
        Map<String,Courses> lastScheduledSemester = null;
        String[] thisSemester = null;
        String nextSemester;

        if (schedule.size() == 0) {
            return getCurrentSemester();
        }
        else {
             lastScheduledSemester = schedule.get(schedule.size() - 1);
        }
        for (Map.Entry<String,Courses> indivMap : lastScheduledSemester.entrySet()) {
            thisSemester = indivMap.getKey().split(" ");
        }

        int year = Integer.parseInt(thisSemester[1]);

        if (thisSemester[0].equals("Fall")) {
            nextSemester = "Spring";
            ++year;
        }
        else {
            nextSemester = "Fall";
        }
        return (nextSemester + " " + year);
    }
    private String getCurrentSemester() {
        Calendar calendar = GregorianCalendar.getInstance(Locale.US);
        String semester = "";

        if ((calendar.get(Calendar.MONTH) + 1) < 7) {
            semester = "Spring";
        }
        else {
            semester = "Fall";
        }
        return (semester + " " + calendar.get(Calendar.YEAR));
    }
}
