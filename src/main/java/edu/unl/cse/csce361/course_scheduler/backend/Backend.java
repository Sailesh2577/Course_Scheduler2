package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.Collection;

public class Backend {
    private static Backend uniqueFacade;
    private Collection<Admin> admins;

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
        //TODO: Read from Collection<Admin> admins to match with an admin
        Admin admin = null;
        return admin;
    }

    public boolean verifyAdmin(Admin admin, String inputId) {
        if (admin != null) {
            if (admin.getId() == inputId) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
