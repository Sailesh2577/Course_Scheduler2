package edu.unl.cse.csce361.course_scheduler.logic;

import edu.unl.cse.csce361.course_scheduler.backend.Admin;
import edu.unl.cse.csce361.course_scheduler.backend.Backend;
import edu.unl.cse.csce361.course_scheduler.backend.Student;

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

    public static Admin getAdminUser(String inputName) {
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

    public Student getStudent(String name, String id) {
        return backendFacade.getStudent(name, id);
    }

    public String getStudentName(Student student) {
        return backendFacade.getStudentName(student);
    }
}
