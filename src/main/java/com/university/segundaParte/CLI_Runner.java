package com.university.segundaParte;

import com.university.segundaParte.CLILogic.CLI;
import com.university.segundaParte.CLILogic.implementations.CRUDRepository;
import com.university.segundaParte.CLILogic.flowActionEntities.FlowActionCourse;
import com.university.segundaParte.CLILogic.flowActionEntities.FlowActionEvaluation;
import com.university.segundaParte.CLILogic.flowActionEntities.FlowActionStudent;
import com.university.segundaParte.CLILogic.implementations.CrudRepoCourse;
import com.university.segundaParte.CLILogic.implementations.CrudRepoEvaluation;
import com.university.segundaParte.CLILogic.implementations.CrudRepoStudent;

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
