package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.*;

public class Student extends User {
    private String name;
    private String studentId;
    private String gradeLevel;
    private FourYearSchedule schedule;


    public Student(String name, String studentId, String gradeLevel) {
        this.name = name;
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return studentId;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String getUsername() {
        return null;
    }

    @Override
    public String toString() {
        return "User: Student, Name: " + name + ", Student Id: " + studentId + ", Grade Level: " + gradeLevel;
    }

    public static Collection<Student> setAllStudents(Collection<Map<String, String>> studentList) {
        List<Student> students = new ArrayList<Student>();

        for (Map<String,String> map : studentList) {
            students.add(new Student(map.get("Name"),map.get("Student Id"),map.get("Grade Level")));
        }
        return students;
    }

    public FourYearSchedule getSchedule() {
        return schedule;
    }


}
