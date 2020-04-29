package edu.unl.cse.csce361.course_scheduler.frontend;

import edu.unl.cse.csce361.course_scheduler.backend.Course;
import edu.unl.cse.csce361.course_scheduler.backend.FourYearSchedule;
import edu.unl.cse.csce361.course_scheduler.backend.Student;
import edu.unl.cse.csce361.course_scheduler.logic.LogicFacade;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CLI {
    private Scanner scanner;
    private final LogicFacade logicFacade = LogicFacade.getInstance();

    public void run() {
        scanner = new Scanner(System.in);
        boolean exit = false;
        int selection;
        boolean validSelection;
        MenuOptions optionSelected = null;

        logicFacade.setAllAdmins();
        logicFacade.setAllStudents();

        while (!exit) {
            validSelection = false;
            System.out.println();
            System.out.println("University of Never Land Course Scheduler");

            for (MenuOptions menop : MenuOptions.values()) {
                System.out.println((menop.ordinal() + 1) + " - " + menop.getDescription());
            }
            System.out.println();
            System.out.println("Please select a login option: ");
            selection = getSelection();
            scanner.nextLine();

            while (!validSelection) {
                try {
                    optionSelected = MenuOptions.values()[selection - 1];
                    validSelection = true;
                }
                catch (ArrayIndexOutOfBoundsException a) {
                    System.out.println("Invalid selection. Please enter a number from the menu above.");
                    selection = getSelection();
                }
            }
            String inputName;
            String inputId;

            switch (optionSelected) {
                case ADMIN_SIDE:
                    System.out.println();
                    System.out.println("Please enter your username: ");
                    inputName = scanner.nextLine();

                    System.out.println("Enter ID: ");
                    inputId = scanner.nextLine();

                    if (logicFacade.adminLogin(logicFacade.getAdminUser(inputName), inputId)) {
                        adminMenu(logicFacade.getAdminName(logicFacade.getAdminUser(inputName)));
                    }
                    else {
                        System.out.println("Username or ID is incorrect");
                    }
                    break;
                case STUDENT_SIDE:
                    //Welcome message to the student side of system
                    System.out.println("Welcome to Student Portal");

                    //Prompt for the user to enter their student id
                    System.out.println("Please enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Please enter student id: ");
                    String studentId = scanner.nextLine();

                    //Check to see if a student exists with this studentId
                    Student student = logicFacade.getStudent(name, studentId);

                    //If student does not exist
                    if(student == null) {
                        //Message announcing student record with inputted student id doesn't exist
                        System.out.println("No student record found with inputted credentials. Returned to main menu: ");


                        //Student record with inputted student id does exist
                    } else {
                        studentMenu(student);
                    }

                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Whoops!");
            }
        }

    }

    public int getSelection() {
        int input = 0;
        boolean isNum = false;

        while (!isNum) {
            try {
                input = scanner.nextInt();
                isNum = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Please input a number from the menu above");
                scanner.nextLine();
            }
            catch (NoSuchElementException noNext) {
                System.out.println("There are no more inputs. Terminating");
                scanner.nextLine();
                input = 2;
                isNum = true;
            }
        }
        return input;
    }

    public void adminMenu(String adminName) {
        boolean goBack = false;
        boolean validSelection;
        int selection;
        AdminOptions optionSelected = null;

        while (!goBack) {
            validSelection = false;

            System.out.println();
            for (AdminOptions adop : AdminOptions.values()) {
                System.out.println((adop.ordinal() + 1) + " - " + adop.getDescription());
            }

            System.out.println();
            System.out.println("Welcome " + adminName + ". Please select an action: ");

            selection = getSelection();
            scanner.nextLine();

            while (!validSelection) {
                try {
                    optionSelected = AdminOptions.values()[selection - 1];
                    validSelection = true;
                }
                catch (ArrayIndexOutOfBoundsException a) {
                    System.out.println("Invalid selection. Please enter a number from the menu above.");
                    selection = getSelection();
                }
            }

            String newStudentName;
            GradeLevels gradeLevelSelected = null;
            String courseName;
            String courseNumber;


            switch (optionSelected) {
                case REGISTER_STUDENT:
                    validSelection = false;
                    System.out.println();
                    System.out.println("Enter student's full name: ");
                    newStudentName = scanner.nextLine();

                    System.out.println();
                    for (GradeLevels gl : GradeLevels.values()) {
                        System.out.println((gl.ordinal() + 1) + " - " + gl.getDescription());
                    }
                    System.out.println("Please select student's grade level: ");

                    selection = getSelection();
                    scanner.nextLine();

                    while (!validSelection) {
                        try {
                            gradeLevelSelected = GradeLevels.values()[selection - 1];
                            validSelection = true;
                        }
                        catch (ArrayIndexOutOfBoundsException a) {
                            System.out.println("Invalid selection. Please enter a number from the menu above.");
                            selection = getSelection();
                        }
                    }

                    logicFacade.registerStudent(newStudentName,gradeLevelSelected.getDescription());

                    break;
                case ADD_COURSE:
                    System.out.println();
                    System.out.println("Please enter course name: ");
                    courseName = scanner.nextLine();

                    System.out.println();
                    System.out.println("Please enter course department code and number (Use format 'XXXX 000')");
                    courseNumber = scanner.nextLine();

                    logicFacade.addNewCourse(courseName,courseNumber);

                    break;
                case BACK:
                    goBack = true;
                    break;
                default:
                    System.out.println("Whomp whomp");
                    break;
            }
        }
    }

    public void studentMenu(Student student) {
        boolean goBack = false;
        boolean validSelection;
        int selection;
        StudentOptions optionSelected = null;


        while(!goBack) {
            //Welcome message
            System.out.println("\nWelcome " + logicFacade.getStudentName(student));
            validSelection = false;

            for (StudentOptions studentSelection : StudentOptions.values()) {
                System.out.println((studentSelection.ordinal() + 1) + " - " + studentSelection.getDescription());
            }
            System.out.print("Please select an option: ");

            selection = getSelection();
            scanner.nextLine();

            while (!validSelection) {
                try {
                    optionSelected = StudentOptions.values()[selection - 1];
                    validSelection = true;
                }
                catch (ArrayIndexOutOfBoundsException a) {
                    System.out.println("Invalid selection. Please enter a number from the menu above.");
                    selection = getSelection();
                }
            }

            String courseNumber;

            switch (optionSelected) {
                case EDIT_SCHEDULE:
                    System.out.println("Here is your schedule.");
                    System.out.println();  //Get student schedule

                    System.out.println("1 - Add Course");
                    System.out.println("2 - Drop Course");
                    System.out.println("3 - Go Back");
                    System.out.println("Please select an option:");
                    int editScheduleOption = scanner.nextInt();

                    if (editScheduleOption == 1) {
                        System.out.println("Please state the course number that you want to add:");
                        courseNumber = scanner.nextLine();
                    }

                    else if(editScheduleOption == 2) {
                        System.out.println("Please state the course number that you want to drop:");
                        courseNumber = scanner.nextLine();
                    }

                    else {
                        goBack = true;
                    }

                    break;
                case ENTER_SCHEDULE:
                    //Enter schedule
                    System.out.println("Please enter the course number you want for your schedule:");
                    courseNumber = scanner.nextLine();

                    //Add new course into schedule
                    Course courses = FourYearSchedule.getSchedule(courseNumber);

                    System.out.println("Course added.");
                    break;
                case BACK:
                    goBack = true;
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }

        }

    }

    enum MenuOptions {
        ADMIN_SIDE("Admin login"),
        STUDENT_SIDE("Student login"),
        EXIT("Exit");

        private final String description;

        MenuOptions(String description) {this.description = description;}

        public String getDescription() {return description;}
    }

    enum AdminOptions {
        REGISTER_STUDENT("Register a new student"),
        ADD_COURSE("Add new course"),
        BACK("Go back");

        private final String description;

        AdminOptions(String description) {this.description = description;}

        public String getDescription() {return description;}
    }

    enum GradeLevels {
        FRESHMAN("Freshman"),
        SOPHOMORE("Sophomore"),
        JUNIOR("Junior"),
        SENIOR("Senior");

        private final String description;

        GradeLevels(String description) {this.description = description;}

        public  String getDescription() {return description;}
    }


    enum StudentOptions {
        EDIT_SCHEDULE("Edit existing schedule"),
        ENTER_SCHEDULE("Enter a schedule"),
        BACK("Go back");

        private final String description;

        StudentOptions(String description) {this.description = description;}

        public String getDescription() {return description;}
    }
}
