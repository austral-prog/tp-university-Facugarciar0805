package com.university.segundaParte.CLILogic.flowActionEntities;

import com.university.segundaParte.CLILogic.InputValidator;
import com.university.segundaParte.CLILogic.implementations.CrudRepoCourse;
import com.university.segundaParte.CLILogic.implementations.CrudRepoEvaluation;
import com.university.segundaParte.CLILogic.implementations.CrudRepoStudent;
import com.university.segundaParte.MenuDisplays;
import com.university.primeraParte.objetos.Course;
import com.university.primeraParte.objetos.evaluations.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowActionEvaluation implements FlowActionInterface{
    CrudRepoStudent crudRepoStudent;
    CrudRepoCourse crudRepoCourse;
    CrudRepoEvaluation crudRepoEvaluation;
    Scanner scanner;
    InputValidator inputValidator;
    MenuDisplays menuDisplays;
    public FlowActionEvaluation(CrudRepoStudent crudRepoStudent, CrudRepoCourse crudRepoCourse, CrudRepoEvaluation crudRepoEvaluation, Scanner scanner){
        this.crudRepoStudent = crudRepoStudent;
        this.scanner = scanner;
        this.inputValidator = new InputValidator();
        this.crudRepoEvaluation = crudRepoEvaluation;
        this.crudRepoCourse = crudRepoCourse;
        this.menuDisplays = new MenuDisplays();
    }

    @Override
    public boolean act() {
        boolean looping = true;
        String action;
        while(looping) {
            menuDisplays.displayActionsMenu("Evaluation");
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
        System.out.println("There has to exist a course to create an evaluation.");
        System.out.print("Enter the course ID: ");
        String subject = null;
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Course course = crudRepoCourse.read(id);
                if(course!= null){
                    System.out.println("You are creating a new evaluation to course: " + course.getCourseName());
                    subject = course.getCourseName();
                }
                else{
                    System.out.println("No course with that ID exists");
                }
                chooseID = false;
            }catch (InputMismatchException e){
                System.out.println("The ID can only have numerical characters");
                System.out.print("Enter a new ID: ");
                scanner.nextLine();
            }
        }while(chooseID);

        if(subject!=null){
            scanner.nextLine();
            System.out.print("Enter the name of the evaluation: ");
            String evalName = scanner.nextLine();
            while(!inputValidator.isValidSubject(evalName)){
                System.out.print("Enter a valid evaluation name: ");
                evalName = scanner.nextLine();
            }
            System.out.print("Enter the grade of the evaluation:  ");
            String grade = scanner.next();
            while(!inputValidator.isValidGrade(grade)){
                System.out.print("Enter a valid grade: ");
                grade = scanner.next();
            }

            String evalType = null;
            scanner.nextLine();
            menuDisplays.displayTypesOfEval();
            boolean loop = true;
            Evaluations evaluations = null;
            while(loop){
                String input = scanner.nextLine();
                switch (input){
                    case "1":
                        evalType = "FINAL_PRACTICAL_WORK";
                        evaluations = new FinalPracticalWork(subject,evalType,evalName,Float.parseFloat(grade));
                        loop = false;
                        break;
                    case "2":
                        evalType = "PRACTICAL_WORK";
                        evaluations = new PraticalWork(subject,evalType,evalName,Float.parseFloat(grade));
                        loop = false;
                        break;
                    case "3":
                        evalType = "WRITTEN_EXAM";
                        evaluations = new WrittenExam(subject,evalType,evalName,Float.parseFloat(grade));
                        loop = false;
                        break;
                    case "4":
                        evalType = "ORAL_EXAM";
                        evaluations = new OralExam(subject,evalType,evalName,Float.parseFloat(grade));
                        loop = false;
                        break;
                    default:
                        System.out.print("Enter a valid Input ");
                }
            }
            boolean chooseID2 = true;
            System.out.print("Enter the ID for your new evaluation: ");
            do{
                try{
                    int id = scanner.nextInt();
                    if(crudRepoEvaluation.read(id)== null){
                        evaluations.setId(id);
                        crudRepoEvaluation.create(evaluations);
                        System.out.println("You created a new " + evalType + " called "+evalName+" of subject " + subject);
                        chooseID2 = false;
                    }
                    else{
                        System.out.println("There is another evaluation with the same id ");
                    }

                }catch (InputMismatchException e){
                    System.out.println("The ID can only have numerical characters");
                    System.out.print("Enter a new ID: ");
                    scanner.nextLine();
                }
            }while(chooseID2);
        }


    }
    @Override
    public void read() {
        System.out.print("Enter the ID of the evaluation you want to read data: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Evaluations evaluations = crudRepoEvaluation.read(id);
                if(evaluations!= null){
                    System.out.println("Subject: " + evaluations.getSubject());
                    System.out.println("Type: " + evaluations.getSubject());
                    System.out.println("Name: " + evaluations.getSubject());
                    System.out.println("Grade: " + evaluations.getSubject());
                    try{
                        System.out.println("Grade: " + evaluations.getStudent().getName());
                    }catch (NullPointerException e){
                        System.out.println("Grade: (no student asigned)");
                    }
                }
                else{
                    System.out.println("No course with that ID exists");
                }
                chooseID = false;
            }catch (InputMismatchException e){
                System.out.println("The ID can only have numerical characters");
                System.out.print("Enter a new ID: ");
                scanner.nextLine();
            }
        }while(chooseID);

    }
    @Override
    public void update() {
        System.out.print("Enter the ID of the evaluation you want to update data: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Evaluations oldEvaluations = crudRepoEvaluation.read(id);
                if(oldEvaluations!=null){
                    String oldSubject = oldEvaluations.getSubject();
                    String oldType = oldEvaluations.getEvaluationType();
                    String oldName = oldEvaluations.getEvaluationName();
                    float oldGrade = oldEvaluations.getFinalGrade();
                    boolean choose2ID = true;
                    String subject = null;
                    String evalType = null;
                    String evalName = null;
                    String grade = null;
                    Evaluations evaluations = null;
                    scanner.nextLine();
                    System.out.print("Enter the ID for the course to update the evaluation: ");
                    do{
                        try {
                            int input = scanner.nextInt();
                            subject = crudRepoCourse.read(input).getCourseName();
                            choose2ID = false;
                        }catch(InputMismatchException e){
                            System.out.println("The ID can only have numerical characters");
                            System.out.print("Enter a new ID: ");
                            scanner.nextLine();
                        }
                    }while(choose2ID);

                    scanner.nextLine();
                    System.out.print("Enter the name evaluation: ");
                    evalName = scanner.nextLine();
                    while(!inputValidator.isValidSubject(evalName)){
                        System.out.print("Enter a valid evaluation name: ");
                        evalName = scanner.nextLine();
                    }
                    System.out.print("Enter the grade of the evaluation: ");
                    grade = scanner.nextLine();
                    while(!inputValidator.isValidGrade(grade)){
                        System.out.print("Enter a valid evaluation name: ");
                        grade = scanner.nextLine();
                    }
                    menuDisplays.displayTypesOfEval();
                    boolean loop = true;
                    while(loop) {
                        String input = scanner.nextLine();
                        switch (input) {
                            case "1":
                                evalType = "FINAL_PRACTICAL_WORK";
                                evaluations = new FinalPracticalWork(subject, evalType, evalName, Float.parseFloat(grade));
                                loop = false;
                                break;
                            case "2":
                                evalType = "PRACTICAL_WORK";
                                evaluations = new PraticalWork(subject, evalType, evalName, Float.parseFloat(grade));
                                loop = false;
                                break;
                            case "3":
                                evalType = "WRITTEN_EXAM";
                                evaluations = new WrittenExam(subject, evalType, evalName, Float.parseFloat(grade));
                                loop = false;
                                break;
                            case "4":
                                evalType = "ORAL_EXAM";
                                evaluations = new OralExam(subject, evalType, evalName, Float.parseFloat(grade));
                                loop = false;
                                break;
                            default:
                                System.out.print("Enter a valid Input ");
                        }
                    }
                        crudRepoEvaluation.update(id, evaluations);
                        System.out.println("Old Data   -->  New Data");
                        System.out.println(oldSubject + " --> "+ evaluations.getSubject());
                        System.out.println(oldType + " --> "+ evaluations.getEvaluationType());
                        System.out.println(oldName + " --> "+ evaluations.getEvaluationName());
                        System.out.println(grade + " --> "+ evaluations.getFinalGrade());

                }
                else{
                    System.out.println("No course with that ID exists");
                }
                chooseID = false;
            }catch (InputMismatchException e){
                System.out.println("The ID can only have numerical characters");
                System.out.print("Enter a new ID: ");
                scanner.nextLine();
            }
        }while(chooseID);
    }
    @Override
    public void delete() {
        System.out.print("Write the evaluation ID you want to delete: ");
        boolean chooseID = true;
        do{
            try{
                int id = scanner.nextInt();
                Evaluations evaluations = crudRepoEvaluation.read(id);
                if(evaluations != null){
                    System.out.println("You are about to delete data of evaluation:  "+ evaluations.getEvaluationName() + ", of type: " + evaluations.getEvaluationType() + ", of subject: " + evaluations.getSubject());
                    System.out.print("Are you sure? Press D to continue or any other key to abort: ");
                    String answer = scanner.next();
                    if(answer.equals("D")||answer.equals("d")){
                        crudRepoEvaluation.delete(id);
                        System.out.println("You deleted data from ID: " + id);
                    }
                    else{
                        System.out.println("You aborted operation.");
                    }
                    chooseID = false;

                }
                else{
                    System.out.println("There is no evaluation with that ID.");
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
        crudRepoEvaluation.printEntity();
    }
}
