package com.university.CLILogic;

import com.university.CLILogic.implementations.CrudRepoStudent;

import com.university.MenuDisplays;
import com.university.primeraParte.objetos.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowActionStudent {
    CrudRepoStudent crudRepoStudent;
    Scanner scanner;
    InputValidator inputValidator;
    public FlowActionStudent(CrudRepoStudent crudRepoStudent,Scanner scanner){
        this.crudRepoStudent = crudRepoStudent;
        this.scanner = scanner;
        inputValidator = new InputValidator();
    }
    public boolean act(){
        MenuDisplays menuDisplays = new MenuDisplays();
        menuDisplays.displayActionsMenu("Student");
        boolean looping = true;
        String action;
        while(looping) {
            menuDisplays.displayActionsMenu("Student");
            action = scanner.next();
            switch (action) {
                case "1":
                    createStudent();
                    looping = askForAnotherAction();
                    break;
                case "2":
                    readStudent();
                    looping = askForAnotherAction();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    return true;
                default:
                    System.out.print("Please enter a valid Input: ");
            }
        }
        return false;
    }
    private void createStudent(){
        System.out.print("Enter the name of the Student you want to create: ");
        String name = scanner.next();
        while(!inputValidator.isValidName(name)){
            System.out.print("Enter a valid name: ");
            name = scanner.next();
        }
        System.out.println("Great!");
        System.out.print("Now enter the email of the Student you want to create: ");
        String email = scanner.next();
        while(!inputValidator.isValidEmail(email)){
            System.out.print("Enter a valid email: ");
            email = scanner.next();
        }

        boolean chooseID = true;
        System.out.print("Now enter an ID for the new student: ");
        do{
            try{
                int id = scanner.nextInt();
                if(crudRepoStudent.read(id)==null){
                    Student student = new Student(name, email);
                    student.setId(id);
                    crudRepoStudent.create(student);
                    chooseID = false;
                    System.out.println("You created the student " + name + ", " + email + ", with ID: " + id);
                }
                else{
                    System.out.println("There is already a student with that ID");
                    System.out.print("Choose other ID: ");
                }
            }catch (InputMismatchException e){
                System.out.println("The ID can only have numerical characters");
                System.out.print("Enter a new ID: ");
                scanner.nextLine(); // Limpiar el buffer
            }
        }while(chooseID);
    }
    private void readStudent(){
        System.out.print("Write the student ID you want to get data from: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Student student = crudRepoStudent.read(id);
                if(student != null){
                    System.out.println("Name: " + student.getName());
                    System.out.println("Email: " + student.getMail());
                    System.out.println("ID: " + student.getId());
                    chooseID = false;
                }
                else{
                    System.out.println("There is no student with that ID.");
                    chooseID = false;
                }

            }catch (InputMismatchException e){
                System.out.println("The ID can only have numerical characters");
                System.out.print("Enter a new ID: ");
                scanner.nextLine(); // Limpiar el buffer
            }
        }while(chooseID);
    }
    private boolean askForAnotherAction() {
        System.out.print("Do you wish to perform another task?: (y/n)");
        String answer;
        while (true) {
            answer = scanner.next();
            switch (answer) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.print("Answer (y/n): ");

            }
        }
    }


}
