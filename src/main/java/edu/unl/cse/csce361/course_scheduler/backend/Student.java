package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.ArrayList;
import java.util.Iterator;

public class Student extends User {
    private String name;
    private String studentId;
    private String gradeLevel;
    private static ArrayList<Student> students = new ArrayList<>();


    public Student(String name, String studentId, String gradeLevel) {
        this.name = name;
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
        students.add(this);
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

    public static Student getStudent(String studentId, String name) {
        Student student = null;
        if(students.size() == 0) {
            return student;
        }
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()) {
            Student currentStudent = iterator.next();
            if(currentStudent.getId().equals(studentId) && currentStudent.getName().equals(name)) {
                student = currentStudent;
            }
        }

        return student;
    }

}
