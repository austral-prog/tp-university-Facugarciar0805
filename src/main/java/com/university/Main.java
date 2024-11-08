package com.university;

import com.university.segundaParte.CLILogic.implementations.CRUDRepository;
import com.university.segundaParte.CLILogic.implementations.CrudRepoCourse;
import com.university.segundaParte.CLILogic.implementations.CrudRepoEvaluation;
import com.university.segundaParte.CLILogic.implementations.CrudRepoStudent;
import com.university.segundaParte.CLI_Runner;

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
