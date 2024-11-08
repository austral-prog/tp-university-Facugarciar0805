package com.university.segundaParte.CLILogic.flowActionEntities;

import com.university.segundaParte.CLILogic.InputValidator;
import com.university.segundaParte.CLILogic.implementations.CrudRepoCourse;
import com.university.segundaParte.CLILogic.implementations.CrudRepoEvaluation;
import com.university.segundaParte.CLILogic.implementations.CrudRepoStudent;
import com.university.segundaParte.MenuDisplays;
import com.university.primeraParte.objetos.Course;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowActionCourse implements FlowActionInterface{
    CrudRepoStudent crudRepoStudent;
    CrudRepoCourse crudRepoCourse;
    CrudRepoEvaluation crudRepoEvaluation;
    Scanner scanner;
    InputValidator inputValidator;
    public FlowActionCourse(CrudRepoStudent crudRepoStudent, CrudRepoCourse crudRepoCourse, CrudRepoEvaluation crudRepoEvaluation, Scanner scanner){
        this.crudRepoStudent = crudRepoStudent;
        this.scanner = scanner;
        this.inputValidator = new InputValidator();
        this.crudRepoEvaluation = crudRepoEvaluation;
        this.crudRepoCourse = crudRepoCourse;
    }

    @Override
    public boolean act() {
        MenuDisplays menuDisplays = new MenuDisplays();
        boolean looping = true;
        String action;
        while(looping) {
            menuDisplays.displayActionsMenu("Course");
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
    public void create() {
        scanner.nextLine();
        System.out.print("Enter the subject of the Course you want to create: ");
        String subject = scanner.nextLine();
        while(!inputValidator.isValidSubject(subject)){
            System.out.print("Enter a valid subject: ");
            subject = scanner.nextLine();
        }
        System.out.print("Enter the professor Name of the Course: ");
        String profName = scanner.nextLine();
        while(!inputValidator.isValidName(profName)){
            System.out.print("Enter a valid name: ");
            profName = scanner.nextLine();
        }
        System.out.print("Enter the class number of the Course: ");
        String classNumber = scanner.next();
        while(!inputValidator.isValidClassNumber(classNumber)){
            System.out.print("Enter a valid class number: ");
            classNumber = scanner.next();
        }
        boolean chooseID = true;
        System.out.print("Now enter an ID for the new course: ");
        do{
            try{
                int id = scanner.nextInt();
                if(crudRepoCourse.read(id)==null){
                    chooseID = false;
                    Course course = new Course(subject, profName, classNumber);
                    course.setId(id);
                    crudRepoCourse.create(course);
                    System.out.println("You created the course " + subject + ", given by: " + profName + ", in class: " + classNumber);
                }
                else{
                    System.out.println("There is already a course with that ID");
                    System.out.print("Choose other ID: ");
                }
            }catch (InputMismatchException e){
                System.out.println("The ID can only have numerical characters");
                System.out.print("Enter a new ID: ");
                scanner.nextLine();
            }
        }while(chooseID);

    }

    @Override
    public void read() {
        boolean chooseID = true;
        System.out.print("Write the course ID you want to get data from: ");
        do{
            try{
                int id = scanner.nextInt();
                Course course = crudRepoCourse.read(id);
                if(course !=null){
                    System.out.println("Subject: " + course.getCourseName());
                    System.out.println("Prof Name: " + course.getProfessor());
                    System.out.println("Class number: " + course.getClassNumber());
                    System.out.println("ID: " + course.getId());
                    chooseID = false;
                }
                else{
                    System.out.println("There is no Couse with that ID.");
                    chooseID = false;
                }
            }catch (InputMismatchException e){
                System.out.println("The ID can only have numerical characters");
                System.out.print("Enter a new ID: ");
                scanner.nextLine();
            }
        }while(chooseID);
    }

    @Override
    public void update() {
        System.out.print("Write the ID of the Course data you want to update: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Course oldCourse = crudRepoCourse.read(id);
                if(oldCourse != null){
                    String oldSubject = oldCourse.getCourseName();
                    String oldProfName = oldCourse.getProfessor();
                    String oldClassNumber = oldCourse.getClassNumber();
                    scanner.nextLine();
                    System.out.print("Enter the subject of the course you want to update: ");
                    String subject = scanner.nextLine();
                    while(!inputValidator.isValidSubject(subject)){
                        System.out.print("Enter a valid subject: ");
                        subject = scanner.nextLine();
                    }

                    System.out.print("Enter the Prof Name of the course you want to update: ");
                    String profName = scanner.next();
                    while(!inputValidator.isValidName(profName)){
                        System.out.print("Enter a valid name: ");
                        profName = scanner.next();
                    }
                    System.out.print("Enter the class number of the Course you want to update: ");
                    String classNumber = scanner.next();
                    while(!inputValidator.isValidClassNumber(classNumber)){
                        System.out.print("Enter a valid class number: ");
                        classNumber = scanner.next();
                    }
                    Course course = new Course(subject, profName, classNumber);
                    crudRepoCourse.update(id,course);
                    System.out.println("Old Data   ---->   New Data");
                    System.out.println(oldSubject + " -> " + course.getCourseName());
                    System.out.println(oldProfName + " -> " + course.getProfessor());
                    System.out.println(oldClassNumber + " -> " + course.getClassNumber());
                    chooseID = false;
                }
                else{
                    System.out.println("There is no course with that ID.");
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
    public void delete() {
        System.out.print("Write the course ID you want to delete: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Course course = crudRepoCourse.read(id);
                if(course != null){
                    System.out.println("You are about to delete data of course:  "+ course.getCourseName() + ", given by:" + course.getProfessor() + ", in class: " + course.getClassNumber());
                    System.out.print("Are you sure? Press D to continue or any other key to abort: ");
                    String answer = scanner.next();
                    if(answer.equals("D")||answer.equals("d")){
                        crudRepoCourse.delete(id);
                        System.out.println("You deleted data from ID: " + id);
                    }
                    else{
                        System.out.println("You aborted operation.");
                    }
                    chooseID = false;

                }
                else{
                    System.out.println("There is no course with that ID.");
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
        crudRepoCourse.printEntity();
    }


}
