package edu.unl.cse.csce361.course_scheduler.backend;

import java.io.File;
import java.util.Collection;

public class Backend {
    private static Backend uniqueFacade;
    private Collection<Admin> admins;
    private Collection<Student> students;
    private CsvReader reader;

    public Backend() {
        reader = new CsvReader();
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

    public void setAllStudents() {
        students = (Student.setAllStudents(reader.readFile("src/main/resources/csv/students.csv")));
    }

    public Student getStudent(String name, String id) {
        for (Student student : students) {
            if (student.getName().equals(name) && student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public String getStudentName(Student student) {
        return student.getName();
    }

}
