package com.university;

import com.university.primeraParte.University;
import com.university.primeraParte.dataWorker.Processor;
import com.university.primeraParte.dataWorker.transformers.TransformerStudentApproved;
import com.university.primeraParte.dataWorker.transformers.TransformerStudentExams;
import com.university.primeraParte.dataWorker.transformers.TransformerStudentsCourses;

public class App {
    public static void main(String[] args) {

        University university= new University();
        TransformerStudentsCourses transformerStudentsCourses = new TransformerStudentsCourses();
        TransformerStudentExams transformerStudentExams = new TransformerStudentExams();
        TransformerStudentApproved transformerStudentApproved = new TransformerStudentApproved();

        //Parte 1
        Processor processorSolution1 = new Processor(transformerStudentsCourses);
        processorSolution1.processData("src/main/resources/input.csv", "src/main/resources/solution.csv", "Student_Name,Course_Count", university);

        //Parte 2
        Processor processorSolution2 = new Processor(transformerStudentExams);
        processorSolution2.processData("src/main/resources/input_2.csv","src/main/resources/solution_2.csv","Subject_Name,Evaluation_Name,Student_Name,Grade", university);

        //Parte 3
        Processor processorSolution3 = new Processor(transformerStudentApproved);
        processorSolution3.processData("src/main/resources/input_3.csv", "src/main/resources/solution_3.csv", "Student_Name,Subject_Name,Report", university);


        //>>>>>>>PARTE 3
    }


    //FINAL ES LA SUMA
    //FOR PRACTICAL WORK
    //FOR ORAL EXAM ONLY ONE GRADE
    //FOR WRITTEN EXAM AVERAGE

}



