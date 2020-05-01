package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.ArrayList;
import java.util.Collection;

public class Backend {
    private static Backend uniqueFacade;
    private Collection<Admin> admins;
    private Collection<Student> students;
    private Collection<Courses> courses;
    private ArrayList<Student> studentList;
    private ArrayList<Courses> courseList;
    private final CsvReader reader;
    private final CsvWriter writer;

    public Backend() {
        reader = new CsvReader();
        writer = new CsvWriter();
    }

    public static Backend getInstance() {
        if (uniqueFacade == null) {
            uniqueFacade = new Backend();
        }
        return uniqueFacade;
    }

    public Admin getAdmin(String username) {
        for (Admin ad : admins) {
            if (ad.getUsername().equals(username)) {
                return ad;
            }
        }
        return null;
    }

    public boolean verifyAdmin(Admin admin, String inputId) {
        if (admin != null) {
            return (admin.getId().equals(inputId));
        }
        return false;
    }

    public void setAllAdmins() {
        admins = (Admin.setAllAdmins(reader.readFile("src/main/resources/csv/admins.csv")));
    }

    public String getAdminName(Admin admin) {
        return admin.getName();
    }

    public void registerStudent(String newStudentName, String description) {
        Student student = new Student(newStudentName,description);
        writer.writeToFile("students.csv",student.toCsvFormat());
        setAllStudents();
    }

    public void addNewCourse(String courseName, String courseNumber) {
        writer.writeToFile("courses.csv", (courseName + ", " + courseNumber));
    }

    public void setAllStudents() {
        students = (Student.setAllStudents(reader.readFile("src/main/resources/csv/students.csv")));
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public Student getStudent(String name, String id) {
        for(Student student: students) {
            if(student.getName().equals(name) && student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public String getStudentName(Student student) {
        return student.getName();
    }

    public String getAddCourseToSchedule(String addCourse) {
        return addCourse;
    }

    public String getDropCourseFromSchedule(String deleteCourse) {
        return deleteCourse;
    }

    /*public Collection<FourYearSchedule> getCourses() {
        return courses;
    }*/

//    public boolean checkStudentExist(Student student, Courses courses){
//        if(student != null){
//            if(studentList.contains(student) == courseList.contains(student)){
//
//            }
//        }
//        studentList.add(student);
//        return true;
//    }

    public String getCourseNumber(Courses course) {
        return course.getCourseNumber();
    }

    public boolean checkCoursesExist(Courses course, String courseNumber) {
        if(course != null) {
            if(course.getCourseNumber().equals(courseNumber)) {
                return true;
            }
        }
        return false;
    }

    public void setAllCourses() {
        courses = (Courses.setAllCourses(reader.readFile("src/main/resources/csv/courses.csv")));
    }

    public Collection<Courses> getCourses() {
        return courses;
    }

    public Courses getCourse(String name, String departmentCode, String courseNumber) {
        for(Courses course: courses) {
            if(course.getName().equals(name) && course.getDepartmentCode().equals(departmentCode) &&
                    course.getCourseNumber().equals(courseNumber)) {
                return course;
            }
        }
        return null;
    }

}
