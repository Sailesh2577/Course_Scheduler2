package edu.unl.cse.csce361.course_scheduler.backend;

public class Admin extends User {
    private String name;
    private String id;
    private String username;

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
