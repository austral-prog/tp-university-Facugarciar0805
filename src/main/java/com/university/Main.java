package com.university;

import com.university.CLILogic.CRUDRepository;
import com.university.CLILogic.implementations.CrudRepoCourse;
import com.university.CLILogic.implementations.CrudRepoEvaluation;
import com.university.CLILogic.implementations.CrudRepoStudent;

public class Main {
    public static void main(String[] args){
        CrudRepoStudent crudRepoStudent = new CrudRepoStudent();
        CrudRepoCourse crudRepoCourse = new CrudRepoCourse();
        CrudRepoEvaluation crudRepoEvaluation = new CrudRepoEvaluation();
        CRUDRepository<?>[] crudInterfaces = {crudRepoStudent, crudRepoCourse, crudRepoEvaluation};

        CLI_Runner cliRunner = new CLI_Runner();
        cliRunner.runCLI(crudInterfaces);
    }
}
