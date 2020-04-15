package edu.unl.cse.csce361.course_scheduler.frontend;

import edu.unl.cse.csce361.course_scheduler.backend.Admin;
import edu.unl.cse.csce361.course_scheduler.backend.User;
import edu.unl.cse.csce361.course_scheduler.logic.LogicFacade;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CLI {
    private Scanner scanner;
    private LogicFacade logicFacade = LogicFacade.getInstance();

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
            String inputName;
            String inputId;

            switch (optionSelected) {
                case ADMIN_SIDE:
                    System.out.println();
                    System.out.println("Please enter your username: ");
                    inputName = scanner.nextLine();

                    System.out.println("Enter ID: ");
                    inputId = scanner.nextLine();

                    if (logicFacade.adminLogin(LogicFacade.getAdminUser(inputName), inputId)) {
                        System.out.println("Admin menu has not yet been implemented");
                    }
                    else {
                        System.out.println("Username or ID is incorrect");
                    }
                    break;
                case STUDENT_SIDE:
                    System.out.println("Student login has not yet been implemented");
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
