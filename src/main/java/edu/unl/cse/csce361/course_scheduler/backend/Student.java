package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.*;

public class Student extends User {
    private String name;
    private String studentId;
    private String gradeLevel;
    private String username;
    private Schedule schedule = new Schedule();
    private static ArrayList<Student> students = new ArrayList<>();


    public Student(String name, String studentId, String gradeLevel) {
        this.name = name;
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
        students.add(this);
    }

    //this constructor is for use with admin student registration
    public Student(String name, String gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.studentId = generateId();
        this.username = generateUsername(name);
        students.add(this);

    }

    //creates a string username following the first initial + last name format
    private String generateUsername(String name) {
        String[] nameSplit = name.split(" ");
        String newUsername = nameSplit[0].charAt(0) + nameSplit[1];

        if (students != null) {
            int i = 1;
            for (Student s : students) {
                if (s.getUsername().equals(newUsername)) {
                    ++i;
                }
            }
            if (i > 1) {
                newUsername = newUsername + Integer.toString(i);
            }
        }
        return newUsername;
    }

    //generates a random eight digit id
    private String generateId() {
        Random rand = new Random();
        int eightDigits = 10000000 + rand.nextInt(90000000);
        return Integer.toString(eightDigits);
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
        if(username == null) {
            return "N/A";
        }
        return username;
    }

    @Override
    public String toString() {
        return "User: Student, Name: " + name + ", Student Id: " + studentId + ", Grade Level: " + gradeLevel;
    }

    //creates a string for use in adding to CSV file
    public String toCsvFormat() {
        return (name + "," + studentId + "," + gradeLevel);
    }


    public static Collection<Student> setAllStudents(Collection<Map<String, String>> studentList) {
        List<Student> students = new ArrayList<Student>();

        for (Map<String,String> map : studentList) {
            students.add(new Student(map.get("Name"),map.get("Student Id"),map.get("Grade Level")));
        }
        return students;
    }

    public Schedule getSchedule() {
        return schedule;
    }


}
