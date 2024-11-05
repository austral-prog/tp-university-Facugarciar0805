package com.university.CLILogic.flowActionEntities;

import com.university.CLILogic.InputValidator;
import com.university.CLILogic.implementations.CrudRepoCourse;
import com.university.CLILogic.implementations.CrudRepoEvaluation;
import com.university.CLILogic.implementations.CrudRepoStudent;

import com.university.MenuDisplays;
import com.university.primeraParte.objetos.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowActionStudent implements FlowActionInterface{
    CrudRepoStudent crudRepoStudent;
    CrudRepoCourse crudRepoCourse;
    CrudRepoEvaluation crudRepoEvaluation;
    Scanner scanner;
    InputValidator inputValidator;
    public FlowActionStudent(CrudRepoStudent crudRepoStudent, CrudRepoCourse crudRepoCourse, CrudRepoEvaluation crudRepoEvaluation, Scanner scanner){
        this.crudRepoStudent = crudRepoStudent;
        this.scanner = scanner;
        this.inputValidator = new InputValidator();
        this.crudRepoEvaluation = crudRepoEvaluation;
        this.crudRepoCourse = crudRepoCourse;
    }
    @Override
    public boolean act(){
        MenuDisplays menuDisplays = new MenuDisplays();
        boolean looping = true;
        String action;
        while(looping) {
            menuDisplays.displayActionsMenu("Student");
            action = scanner.next();
            switch (action) {
                case "1":
                    create();
                    looping = askForAnotherAction();
                    break;
                case "2":
                    read();
                    looping = askForAnotherAction();
                    break;
                case "3":
                    update();
                    looping = askForAnotherAction();
                    break;
                case "4":
                    delete();
                    looping = askForAnotherAction();
                    break;
                case "5":
                    printData();
                    looping = askForAnotherAction();
                    break;
                case "6":
                    return true;
                default:
                    System.out.print("Please enter a valid Input: ");
            }
        }
        return false;
    }
    @Override
    public  void create(){
        System.out.print("Enter the name of the Student you want to create: ");
        String name = scanner.nextLine();
        while(!inputValidator.isValidName(name)){
            System.out.print("Enter a valid name: ");
            name = scanner.nextLine();
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
    @Override
    public void read(){
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
    @Override
    public void update(){
        System.out.print("Write the ID of the Student data you want to update: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Student student = crudRepoStudent.read(id);
                if(student != null){
                    String oldName = student.getName();
                    String oldEmail = student.getMail();
                    scanner.nextLine();
                    System.out.print("Enter the name of the Student you want to update: ");
                    String name = scanner.nextLine();
                    while(!inputValidator.isValidName(name)){
                        System.out.print("Enter a valid name: ");
                        name = scanner.nextLine();
                    }

                    System.out.print("Enter the email of the Student you want to update: ");
                    String email = scanner.next();
                    while(!inputValidator.isValidEmail(email)){
                        System.out.print("Enter a valid email: ");
                        email = scanner.next();
                    }
                    Student student1 = new Student(name, email);
                    crudRepoStudent.update(id, student1);
                    System.out.println("Old Data   ->  New Data");
                    System.out.println(oldName + " -> " + student1.getName());
                    System.out.println(oldEmail + " -> " + student1.getMail());
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
    @Override
    public void delete(){
        System.out.print("Write the student ID you want to delete: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Student student = crudRepoStudent.read(id);
                if(student != null){
                    System.out.println("You are about to delete data of student "+ student.getName() + ", " + student.getMail());
                    System.out.print("Are you sure? Press D to continue or any other key to abort: ");
                    String answer = scanner.next();
                    if(answer.equals("D")||answer.equals("d")){
                        crudRepoStudent.delete(id);
                        System.out.println("You deleted data from ID: " + id);
                    }
                    else{
                        System.out.println("You aborted operation.");
                    }
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
    @Override
    public boolean askForAnotherAction() {
        System.out.print("Do you wish to perform another task? (y/n): ");
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

    @Override
    public void printData() {
        crudRepoStudent.printEntity();
    }


}
