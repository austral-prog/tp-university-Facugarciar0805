package com.university;

import com.university.CLILogic.CLI;
import com.university.CLILogic.CRUDRepository;
import com.university.CLILogic.FlowActionStudent;
import com.university.CLILogic.implementations.CrudRepoCourse;
import com.university.CLILogic.implementations.CrudRepoEvaluation;
import com.university.CLILogic.implementations.CrudRepoStudent;

import java.awt.*;
import java.util.Scanner;
public class CLI_Runner implements CLI {
    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        MenuDisplays menuDisplays = new MenuDisplays();
        Scanner scanner = new Scanner(System.in);
        CrudRepoStudent crudRepoStudent = new CrudRepoStudent();
        FlowActionStudent flowActionStudent = new FlowActionStudent(crudRepoStudent, scanner);
        CrudRepoCourse crudRepoCourse = new CrudRepoCourse();
        CrudRepoEvaluation crudRepoEvaluation = new CrudRepoEvaluation();

        System.out.println("Welcome to the Hogwarts School CLI");
        System.out.println("Here you can load,read and delete data of all the school");
        boolean looping = true;
        do{
            menuDisplays.displayInitialMenu();
            String data = scanner.next();
            switch (data){
                case "1":
                    looping = flowActionStudent.act();
                    break;
                case "2":
                    menuDisplays.displayActionsMenu(crudRepoCourse.getIdentifier());
                    String courseAction = scanner.next();
                    break;
                case "3":
                    menuDisplays.displayActionsMenu(crudRepoEvaluation.getIdentifier());
                    String evaluationAction = scanner.next();
                    break;
                case "4":
                    looping = false;
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }while(looping);
        System.out.println("Process finished");

    }



}
