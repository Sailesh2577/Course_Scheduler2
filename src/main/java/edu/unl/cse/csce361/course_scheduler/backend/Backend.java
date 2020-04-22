package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.Collection;

public class Backend {
    private static Backend uniqueFacade;
    private Collection<Admin> admins;
    private Collection<Student> students;
    private Collection<FourYearSchedule> courses;
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

    public Collection<FourYearSchedule> getCourses() {
        return courses;
    }

    public String getCourseNumber(FourYearSchedule course) {
        return course.getCourseNumber();
    }

    public boolean checkCoursesExist(FourYearSchedule course, String courseNumber) {
        if(course != null) {
            if(course.getCourseNumber().equals(courseNumber)) {
                return true;
            }
        }
        return false;
    }

}
