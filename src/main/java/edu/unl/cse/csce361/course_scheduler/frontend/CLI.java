package edu.unl.cse.csce361.course_scheduler.frontend;

import edu.unl.cse.csce361.course_scheduler.Backend.Courses;
import edu.unl.cse.csce361.course_scheduler.Backend.FourYearSchedule;
import edu.unl.cse.csce361.course_scheduler.Backend.Student;
import edu.unl.cse.csce361.course_scheduler.Backend.User;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CLI {
    private Scanner scanner;

//setting this up like the car rental system assignment
    public void run() {
        scanner = new Scanner(System.in);
        boolean exit = false;
        int selection;
        boolean validSelection;
        MenuOptions optionSelected = null;

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

            switch (optionSelected) {
                case ADMIN_SIDE:
                    System.out.println("Admin login has not yet been implemented");
                    break;
                case STUDENT_SIDE:
                    //Welcome message to the student side of system
                    System.out.println("Welcome to Student Portal");

                    //Prompt for the user to enter their student id
                    System.out.print("Please enter student id: ");
                    String studentId = scanner.nextLine();

                    //Check to see if a student exists with this studentId
                    User student = Student.getStudent(studentId);

                    //If student does not exist
                    if(student == null) {
                        //Message announcing student record with inputted student id doesn't exist
                        System.out.println("No student record with this student id. Returned to main menu: ");


                        //Student record with inputted student id does exist
                    } else {
                        //Welcome message
                        System.out.println("Welcome " + student.getName());

                        //Prompt the user to enter an option of either editing schedule or entering schedule
                        System.out.println("1 - Edit Schedule");
                        System.out.println("2 - Enter Schedule");
                        System.out.println("Please select an option:");
                        int scheduleOption = scanner.nextInt();

                        if(scheduleOption == 1) {
                            //Editing schedule
                            System.out.println("Not yet implemented");
                        } else if(scheduleOption == 2) {
                            //Enter schedule
                            System.out.println("Please enter the course number you want for your schedule.");
                            String courseNumber = scanner.nextLine();

                            //Add new course into schedule
                            Courses courses = FourYearSchedule.getSchedule(courseNumber);

                             System.out.println("Course added.");
                        }

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

    enum MenuOptions {
        ADMIN_SIDE("Admin login"),
        STUDENT_SIDE("Student login"),
        EXIT("Exit");

        private String description;

        MenuOptions(String description) {this.description = description;}

        public String getDescription() {return description;}
    }
}
