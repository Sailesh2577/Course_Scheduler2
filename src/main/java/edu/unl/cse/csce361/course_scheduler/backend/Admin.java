package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Admin extends User {
    private String name;
    private String id;
    private String username;

    public Admin(String name, String username, String id) {
        this.name = name;
        this.username = username;
        this.id = id;
    }

    public static Collection<Admin> setAllAdmins(Collection<Map<String, String>> adminList) {
        List<Admin> admins = new ArrayList<Admin>();

        for (Map<String,String> map : adminList) {
            admins.add(new Admin(map.get("Name"),map.get("Username"),map.get("ID")));
        }
        return admins;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    String getId() {
        return id;
    }

    @Override
    String getUsername() {
        return username;
    }
}
