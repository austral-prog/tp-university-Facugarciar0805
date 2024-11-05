package com.university;

import com.university.CLILogic.CLI;
import com.university.CLILogic.implementations.CRUDRepository;
import com.university.CLILogic.flowActionEntities.FlowActionCourse;
import com.university.CLILogic.flowActionEntities.FlowActionEvaluation;
import com.university.CLILogic.flowActionEntities.FlowActionStudent;
import com.university.CLILogic.implementations.CrudRepoCourse;
import com.university.CLILogic.implementations.CrudRepoEvaluation;
import com.university.CLILogic.implementations.CrudRepoStudent;

import java.util.Scanner;
public class CLI_Runner implements CLI {
    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        MenuDisplays menuDisplays = new MenuDisplays();
        Scanner scanner = new Scanner(System.in);
        CrudRepoStudent crudRepoStudent = new CrudRepoStudent();
        CrudRepoCourse crudRepoCourse = new CrudRepoCourse();
        CrudRepoEvaluation crudRepoEvaluation = new CrudRepoEvaluation();
        FlowActionStudent flowActionStudent = new FlowActionStudent(crudRepoStudent, crudRepoCourse, crudRepoEvaluation, scanner);
        FlowActionCourse flowActionCourse = new FlowActionCourse(crudRepoStudent, crudRepoCourse, crudRepoEvaluation, scanner);
        FlowActionEvaluation flowActionEvaluation = new FlowActionEvaluation(crudRepoStudent, crudRepoCourse, crudRepoEvaluation, scanner);

        System.out.println("Welcome to the Hogwarts University CLI");
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
                    looping = flowActionCourse.act();
                    break;
                case "3":
                    looping = flowActionEvaluation.act();
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
