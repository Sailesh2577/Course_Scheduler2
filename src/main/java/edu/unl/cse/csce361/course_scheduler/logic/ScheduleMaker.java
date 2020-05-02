package edu.unl.cse.csce361.course_scheduler.logic;

import edu.unl.cse.csce361.course_scheduler.backend.Courses;
import edu.unl.cse.csce361.course_scheduler.backend.Schedule;
import edu.unl.cse.csce361.course_scheduler.backend.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ScheduleMaker {
    private final LogicFacade logicFacade = LogicFacade.getInstance();

    public Schedule prepareSchedule() {
        //Get list of all students in the system
        System.out.println("Running Prepare Schedule");

        Collection<Student> students = logicFacade.getStudents();
        Iterator<Student> iterator = students.iterator();

        ArrayList<Courses> semesterCourses = new ArrayList<>();
        ArrayList<Courses> mostRequestedCourses = new ArrayList<>();
        ArrayList<Courses> juniorAndSeniorRequestedCourses = new ArrayList<>();
        ArrayList<Courses> cleanSemesterCourses = new ArrayList<>();
        Schedule optimizedSchedule = new Schedule();


        System.out.println("Just before while loop");
        //Iterate through all the students
        while(iterator.hasNext()) {
            Student student = iterator.next();
            //Get the student's four year schedule
            Schedule studentSchedule = student.getSchedule();


            for(int i = 0; i < 8; i++) {
                semesterCourses.addAll(getSemesterCourses("Semester " + (i+1), studentSchedule));
                mostRequestedCourses.addAll(mostRequestedCourses(semesterCourses));
                juniorAndSeniorRequestedCourses.addAll(juniorAndSeniorRequest("Semester " + (i+1), semesterCourses));
                cleanSemesterCourses.addAll(nonDuplicateList(mostRequestedCourses, juniorAndSeniorRequestedCourses));

                Iterator<Courses> semesterCoursesIterator = cleanSemesterCourses.iterator();
                while(semesterCoursesIterator.hasNext()) {
                    optimizedSchedule.addCourse("Semester " + (i+1), semesterCoursesIterator.next());
                }
            }

        }
        return optimizedSchedule;

    }

    public ArrayList<Courses> getSemesterCourses(String semester, Schedule studentSchedule) {
        ArrayList<Courses> semesterCourses = new ArrayList<>();

        ArrayList<Map<String, Courses>> schedule = studentSchedule.getSchedule();
        Iterator<Map<String, Courses>> iterator = schedule.iterator();

        while(iterator.hasNext()) {
            Map<String, Courses> course = iterator.next();
            if(course.containsKey(semester)) {
                semesterCourses.add(course.get(semester));
            }
        }


        return semesterCourses;
    }


    public ArrayList<Courses> mostRequestedCourses (ArrayList<Courses> courses) {
        ArrayList<Courses> mostRequestedCourses = new ArrayList<>();

        int count;
        //Least number of students that need to have requested a single course in order to be considered in proposed
        //schedule - Can change the number depending on number of students in total
        int minimumRequest = 2;
        Courses course;
        Courses courseToCheck;

        for(int i = 0; i < courses.size(); i++) {
            course = courses.get(i);
            count = 0;
            for(int j = i + 1; j < courses.size(); j++) {
                courseToCheck = courses.get(j);
                if(course.equals(courseToCheck)) {
                    count++;
                }
            }
            if(count >= minimumRequest) {
                mostRequestedCourses.add(course);
            }
        }

        return mostRequestedCourses;
    }


    public ArrayList<Courses> juniorAndSeniorRequest (String semester, ArrayList<Courses> courses) {
        ArrayList<Courses> juniorAndSeniorRequest = new ArrayList<>();
        Collection<Student> students = logicFacade.getStudents();
        Iterator<Student> iterator = students.iterator();
        Courses course, courseToCheck;

        while(iterator.hasNext()) {
            Student student = iterator.next();

            if(student.getGradeLevel().equals("Junior") || student.getGradeLevel().equals("Senior")) {
                Schedule schedule = student.getSchedule();
                ArrayList<Map<String, Courses>> listOfSemesterCourses = schedule.getSchedule();
                Iterator<Map<String, Courses>> scheduleIterator = listOfSemesterCourses.iterator();

                while(scheduleIterator.hasNext()) {
                    Map<String, Courses> semesterCourse = scheduleIterator.next();

                    if(semesterCourse.containsKey(semester)) {
                        course = semesterCourse.get(semester);

                        for(int i = 0; i < courses.size(); i++) {
                            courseToCheck = courses.get(i);

                            if(course.equals(courseToCheck)) {
                                if(!juniorAndSeniorRequest.contains(course)) {
                                    juniorAndSeniorRequest.add(course);
                                }
                            }
                        }
                    }
                }
            }
        }


        return juniorAndSeniorRequest;
    }


    public ArrayList<Courses> nonDuplicateList (ArrayList<Courses> listA, ArrayList<Courses> listB) {

        for(int i = 0; i < listB.size(); i++) {
            if(!listA.contains(listB.get(i))) {
                listA.add(listB.get(i));
            }
        }


        return listA;
    }
}
