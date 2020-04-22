package edu.unl.cse.csce361.course_scheduler.backend;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import edu.unl.cse.csce361.course_scheduler.backend.Admin;

public class Backend {
    private static Backend uniqueFacade;
    private Collection<Admin> admins;
    private CsvReader reader;
    private CsvWriter writer;

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

    public Collection<Admin> getAllAdmins() {
        return admins;
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
            if (admin.getId().equals(inputId)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void setAllAdmins() {
        File file = new File("resources/csv/admins.csv");

        admins = (Admin.setAllAdmins(reader.readFile("src/main/resources/csv/admins.csv")));
    }

    public String getAdminName(Admin admin) {
        return admin.getName();
    }

    public void registerStudent(String newStudentName, String description) {
        Student student = new Student(newStudentName,description);
        writer.writeToFile("students.csv",student.toCsvFormat());
    }

    public void addNewCourse(String courseName, String courseNumber) {
        writer.writeToFile("courses.csv", (courseName + ", " + courseNumber));
    }
}
