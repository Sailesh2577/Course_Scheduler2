package edu.unl.cse.csce361.course_scheduler.Backend;

public class StudentImpl implements Student {
    private String name;
    private String studentId;
    private String gradeLevel;


    public StudentImpl (String name, String studentId, String gradeLevel) {
        super();
        this.name = name;
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

}
