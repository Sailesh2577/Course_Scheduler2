package edu.unl.cse.csce361.course_scheduler.backend;

import java.util.Collection;
import java.util.Map;

public class Backend {
    private static Backend uniqueFacade;
    private Collection<Admin> admins;
    private Collection<Student> students;
    private Collection<Courses> courses;
    private final CsvReader reader;
    private final CsvWriter writer;
    private final String NEW_SCHEDULE = "Semester,Name,Department Code,Course Number";

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
        writer.writeNewFile(student.getScheduleFilename(),NEW_SCHEDULE);
        setAllStudents();
    }

    public void addNewCourse(String name, String id, String num) {
        writer.writeToFile("courses.csv", (name + ", " + id + "," + num));
    }

    public void setAllStudents() {
        students = (Student.setAllStudents(reader.readFile("src/main/resources/csv/students.csv")));
    }

    public Collection<Student> getStudents() {
        return students;
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

    public boolean checkCoursesExist(Courses course, String courseNumber) {
        if(course != null) {
            if(course.getCourseNumber().equals(courseNumber)) {
                return true;
            }
        }
        return false;
    }

    public void setAllCourses() {
        courses = (Courses.setAllCourses(reader.readFile("src/main/resources/csv/courses.csv")));
    }

    public Courses getCourse(String name, String departmentCode, String courseNumber) {
        for(Courses course: courses) {
            if(course.getName().equals(name) && course.getDepartmentCode().equals(departmentCode) &&
                    course.getCourseNumber().equals(courseNumber)) {
                return course;
            }
        }
        return null;
    }

    public void showAdminSchedule() {
        OptimizedSchedule optimalSchedule = new OptimizedSchedule(students);
        optimalSchedule.printSchedule();
    }

    public void printSchedule(Schedule schedule) {
        schedule.printSchedule();
    }

    public boolean addCourse(Student student, String courseNumber) {
        if (findCourseByNumber(courseNumber) != null) {
            student.getSchedule().addCourse(student.getSchedule().getNextSemester(),findCourseByNumber(courseNumber));
            writer.writeToFile(student.getScheduleFilename(),findCourseByNumber(courseNumber).toCsvFormat());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean dropCourse(Student student, String courseNumber) {
        if(findCourseByNumber(courseNumber) != null) {
            student.getSchedule().deleteCourse(student.getSchedule().getNextSemester(), findCourseByNumber(courseNumber));
            writer.writeToFile(student.getScheduleFilename(), findCourseByNumber(courseNumber).toCsvFormat());
            return true;
        }
        return false;
    }


    private Courses findCourseByNumber(String courseNumber) {
        for (Courses course : courses) {
            if (course.getCourseNumber().equals(courseNumber)) {
                return course;
            }
        }
        return null;
    }

    public void updateStudentSchedules() {
        for (Student student : students) {
            String filename = "src/main/resources/csv/schedules/" + student.getId() + "_schedule.csv";
            Collection<Map<String,String>> readSchedule = reader.readFile(filename);

            if (readSchedule != null) {
                student.setSchedule(new Schedule(readSchedule));
            }
            else {
                writer.writeNewFile(student.getScheduleFilename(),NEW_SCHEDULE);
            }
        }
    }
}
