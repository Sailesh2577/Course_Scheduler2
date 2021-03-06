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

    public void addNewCourse(String name, String id, String num) {
        backendFacade.addNewCourse(name,id,num);
    }

    public boolean courseExistence(Courses course, String courseNumber) {return
            backendFacade.checkCoursesExist(course,  courseNumber);}

    public Student getStudent(String name, String id) {
        return backendFacade.getStudent(name, id);
    }

    public String getStudentName(Student student) {
        return backendFacade.getStudentName(student);
    }

    public void setAllStudents() {
        backendFacade.setAllStudents();
    }

    public void showAdminSchedule() {
        backendFacade.showAdminSchedule();
    }

    public void setAllCourses() {
        backendFacade.setAllCourses();
    }

    public Courses getCourse(String name, String departmentCode, String courseNumber) {
        return backendFacade.getCourse(name, departmentCode, courseNumber);
    }

    public void printSchedule(Schedule schedule) {
        backendFacade.printSchedule(schedule);
    }

    public boolean addCourse(Student student, String courseNumber) {
        return backendFacade.addCourse(student,courseNumber);
    }

    public boolean dropCourse(Student student, String courseNumber) {
        return  backendFacade.dropCourse(student, courseNumber);
    }

    public void updateStudentSchedules() {
        backendFacade.updateStudentSchedules();
    }

    public void printCourses() {
        backendFacade.printCourses();
    }

    public Schedule prepareSchedule() {
        ScheduleMaker scheduleMaker = new ScheduleMaker();
        return scheduleMaker.prepareSchedule();
    }

    public Schedule getSchedule(Student student) {
        return backendFacade.getSchedule(student);
    }

    public Collection<Student> getStudents() {
        return backendFacade.getStudents();
    }

}
