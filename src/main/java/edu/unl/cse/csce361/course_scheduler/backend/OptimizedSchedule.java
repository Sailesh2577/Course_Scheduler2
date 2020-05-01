package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.*;

public class OptimizedSchedule {

    private static ArrayList<Map<String, Courses>> schedule = new ArrayList<>();

    OptimizedSchedule(Collection<Student> studentList) {
        Calendar calendar = GregorianCalendar.getInstance(Locale.US);
        String semesterPointer = getCurrentSemester(calendar);
        Schedule schedulePointer;
        List<Courses> courseCountList = new ArrayList<Courses>();


        for (int i = 0; i < 8; ++i) {
            for (Student student : studentList) {
                schedulePointer = student.getSchedule();
                for (Map<String,Courses> map : schedulePointer.getSchedule()) {
                    if (map.containsKey(semesterPointer)) {
                        courseCountList.add(map.get(semesterPointer));
                    }
                }
            }
            Map<String,Courses> scheduleMap = new HashMap<>();
            scheduleMap.put(semesterPointer,mostRequested(courseCountList));
            schedule.add(scheduleMap);
            semesterPointer = getNextSemester(semesterPointer);
        }
    }

    private String getNextSemester(String semesterPointer) {
        String[] semesterSplit = semesterPointer.split(" ");
        String newSemesterPointer = "";
        int year = Integer.parseInt(semesterSplit[1]);

        if (semesterSplit[0].equals("Fall")) {
            newSemesterPointer = "Spring";
            ++year;
        }
        else {
            newSemesterPointer = "Fall";
        }
        return (newSemesterPointer + " " + year);
    }

    private Courses mostRequested(List<Courses> courseCountList) {
        Courses mostRequested = null;
        Courses prevCourse = new Courses("start","strt","srt");

        for (Courses course : courseCountList) {
            if (Collections.frequency(courseCountList,course) > Collections.frequency(courseCountList,prevCourse)) {
                mostRequested = course;
            }
        }
        return mostRequested;
    }

    private String getCurrentSemester(Calendar calendar) {
        String semester = "";

        if ((calendar.get(Calendar.MONTH) + 1) < 7) {
            semester = "Spring";
        }
        else {
            semester = "Fall";
        }
        return (semester + " " + calendar.get(Calendar.YEAR));
    }

/*    public static void printAdminSchedule(List<Courses> optimalSchedule) {
        Calendar calendar = GregorianCalendar.getInstance(Locale.US);
        int currentYear = calendar.get(Calendar.YEAR);
        String semester = "";

        //0-7 will count as spring semester, there is no summer semester for now
        if ((calendar.get(Calendar.MONTH) + 1) < 7) {
            semester = "Spring";
        }
        else {
            semester = "Fall";
        }

        System.out.println();
        for (Courses course: optimalSchedule) {
            System.out.println("Semester: " + semester + " " + currentYear);
            System.out.println(" - " + course.toString());
            System.out.println();
            if (semester.equals("Fall")) {
                semester = "Spring";
                ++currentYear;
            }
            else {
                semester = "Fall";
            }
        }
    }
*/
    public void printSchedule() {
        System.out.println();

        for (Map<String,Courses> map : schedule) {
            for (Map.Entry<String,Courses> indivMap : map.entrySet()) {
                System.out.println("Semester: " + indivMap.getKey());
                if (indivMap.getValue() != null) {
                    System.out.println("   - " + indivMap.getValue().toString());
                }
                else {
                    System.out.println("   - null");
                }
                System.out.println();

            }
        }
    }
}
