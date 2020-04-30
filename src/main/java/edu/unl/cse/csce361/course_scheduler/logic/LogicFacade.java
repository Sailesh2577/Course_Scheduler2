package edu.unl.cse.csce361.course_scheduler.logic;

import edu.unl.cse.csce361.course_scheduler.backend.*;

import java.util.Collection;

public class LogicFacade {
    private static LogicFacade uniqueFacade;
    private static Backend backendFacade;

    private LogicFacade() {
        backendFacade = Backend.getInstance();
    }

    public static LogicFacade getInstance() {
        if (uniqueFacade == null) {
            uniqueFacade = new LogicFacade();
        }
        return uniqueFacade = new LogicFacade();
    }

    public Admin getAdminUser(String inputName) {
        return backendFacade.getAdmin(inputName);
    }

    public boolean adminLogin(Admin admin, String inputId) {
        return backendFacade.verifyAdmin(admin, inputId);
    }

    public void setAllAdmins() {
        backendFacade.setAllAdmins();
    }

    public String getAdminName(Admin admin) {
        return backendFacade.getAdminName(admin);
    }

    public void registerStudent(String newStudentName, String description) {
        backendFacade.registerStudent(newStudentName,description);
    }

    public void addNewCourse(String courseName, String courseNumber) {
        backendFacade.addNewCourse(courseName,courseNumber);
    }

    public boolean courseExistence(FourYearSchedule course, String courseNumber) {return
            backendFacade.checkCoursesExist(course,  courseNumber);}

    public String getCourseNumber(FourYearSchedule course) {return backendFacade.getCourseNumber(course);}

    public Student getStudent(String name, String id) {
        return backendFacade.getStudent(name, id);
    }

    public String getStudentName(Student student) {
        return backendFacade.getStudentName(student);
    }


    public void setAllStudents() {
        backendFacade.setAllStudents();
    }

    public Collection<Student> getStudents() {
        return backendFacade.getStudents();
    }

    public void setAllCourses() {
        backendFacade.setAllCourses();
    }

    public Collection<Courses> getCourses() {
        return backendFacade.getCourses();
    }

    public Courses getCourse(String name, String departmentCode, String courseNumber) {
        return backendFacade.getCourse(name, departmentCode, courseNumber);
    }

}
