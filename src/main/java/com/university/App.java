package com.university;

import com.university.aprovedCheckers.AverageAboveValue;
import com.university.aprovedCheckers.MaxAboveValue;
import com.university.aprovedCheckers.MinAboveValue;
import com.university.creators.EvaluationCreator2;
import com.university.creators.evaluation.EvaluationCreator;
import com.university.csvWorker.*;
import com.university.creators.course.CourseCreator;
import com.university.creators.student.StudentCreator;
import com.university.objetos.course.Course;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Final;
import com.university.objetos.evaluations.Parcial;
import com.university.objetos.evaluations.TrabajoPractico;
import com.university.objetos.student.Student;
import com.university.sorter.Sorter;

import java.util.*;

public class App {
    public static void main(String[] args) {

        //Variables principales
        List<String[]> dataStudentsExams;
        List<String[]> dataStudentCourses;
        List<Student> studentsList = new ArrayList<>();
        List<Course> coursesList = new ArrayList<>();
        List<Evaluations> evaluationsList = new ArrayList<>();


        //Creo un lector y meto la info de input.csv en la variable data
        CsvReader reader = new CsvReader();
        dataStudentCourses = reader.readCsv("src/main/resources/input.csv");


        //Inicializo un creador de Students, un creador de cursos, uno de examenes y un sorter
        StudentCreator studentCreator = new StudentCreator();
        CourseCreator courseCreator = new CourseCreator();
        EvaluationCreator evaluationCreator = new EvaluationCreator();
        Sorter sorter = new Sorter();

        //Creo todos los students y cursos a partir de input.csv
        for (String[] linea : dataStudentCourses) {
            if (dataStudentCourses.indexOf(linea) == 0) {
                continue;
            } else {
                Student student = studentCreator.createObject(studentsList, linea);
                Course course = courseCreator.createObject(coursesList, linea);
                student.addCourse(course);
                course.addStudent(student);
            }

        }

        //Hago una lista de strings para el formato del expected.csv
        List<String> listaStrings = new ArrayList<>();
        for (Student s : studentsList) {
            listaStrings.add(s.toStringForSolutionCsv());
        }

        //Ordeno la lista alfebeticamente
        List<String> solution = sorter.sortStrings(listaStrings);

        //Creo un escritor de csv y escribo el solution.csv
        CsvWriter writer = new CsvWriter();
        writer.writeCsv("src/main/resources/solution.csv", "Student_Name,Course_Count", solution);


        //>>>>>>PARTE DOS


        //leo el input 2 y creo todas las evaluaciones
        dataStudentsExams = reader.readCsv("src/main/resources/input_2.csv");
        for (String[] linea : dataStudentsExams) {
            if (dataStudentsExams.indexOf(linea) == 0) {
                continue;
            } else {
                for (Student student : studentsList) {
                    if (linea[0].equals(student.getName())) {
                        Evaluations evaluation = evaluationCreator.createEvaluations(student, linea);
                        student.addEvaluation(evaluation);
                        evaluation.setStudent(student);
                        break;
                    }
                }
            }
        }
        EvaluationCreator2 evaluationCreator2 = new EvaluationCreator2();
        for (String[] linea : dataStudentsExams) {
            if (dataStudentsExams.indexOf(linea) == 0) {
                continue;
            } else {
                for (Student student : studentsList) {
                    if (linea[0].equals(student.getName())) {
                        Evaluations evaluation = evaluationCreator.createEvaluations(student, linea);
                        student.addEvaluation(evaluation);
                        evaluation.setStudent(student);
                        break;
                    }
                }
            }
        }

        //Hago una lista total de evaluaciones
        for (Student s : studentsList) {
            for (Evaluations e : s.getEvaluations()) {
                evaluationsList.add(e);
            }
        }

        //Paso todas la evaluaciones al formato string y las ordeno
        List<String> listaSolution21 = new ArrayList<>();
        for (Evaluations e : evaluationsList) {
            listaSolution21.add(e.toStringForExpected2());
        }
        listaSolution21 = sorter.sortStrings(listaSolution21);

        //escribo el solution_2.csv
        writer.writeCsv("src/main/resources/solution_2.csv", "Subject_Name,Evaluation_Name,Student_Name,Grade", listaSolution21);


        //>>>>>>>PARTE 3

        //leo el input_3.csv
        List<String[]> input3 = reader.readCsv("src/main/resources/input_3.csv");

        MaxAboveValue maxAboveValue = new MaxAboveValue();
        MinAboveValue minAboveValue = new MinAboveValue();
        AverageAboveValue averageAboveValue = new AverageAboveValue();

        for(Student student: studentsList){
            for(String[] line : input3){
                if(student.isOnCourse(line[0])){
                    if(line[3].contains("TP Final")){
                        List<Evaluations> evaluaciones= new ArrayList<>();
                        for(TrabajoPractico tp: student.getTps()){
                            if(tp.getSubject().equals(line[0]) && tp.getEvaluationName().equals("TP Final")){
                                evaluaciones.add(tp);
                            }
                        }
                        student.addToReport(line[0], maxAboveValue.checkApproved(evaluaciones,Integer.parseInt(line[2])));
                    } else if (line[3].contains("TP")) {
                        List<Evaluations> evaluaciones= new ArrayList<>();
                        for(TrabajoPractico tp: student.getTps()){
                            if(tp.getSubject().equals(line[0]) && tp.getEvaluationName().contains("TP")&&!(tp.getSubject().contains("TP Final"))){
                                evaluaciones.add(tp);
                            }
                        }
                        student.addToReport(line[0], averageAboveValue.checkApproved(evaluaciones,Integer.parseInt(line[2])));
                    } else if (line[3].contains("Final")) {
                        List<Evaluations> evaluaciones= new ArrayList<>();
                        for(Final final1: student.getFinales()){
                            if(final1.getSubject().equals(line[0]) && final1.getEvaluationName().contains("Final")&&!(final1.getSubject().contains("TP Final"))){
                                evaluaciones.add(final1);
                            }
                        }
                        student.addToReport(line[0], maxAboveValue.checkApproved(evaluaciones,Integer.parseInt(line[2])));

                    }else{
                        List<Evaluations> evaluaciones= new ArrayList<>();
                        for(Parcial parcial: student.getParciales()){
                            if(parcial.getSubject().equals(line[0]) && parcial.getEvaluationName().contains("Parcial")){
                                evaluaciones.add(parcial);
                            }
                        }
                        student.addToReport(line[0], minAboveValue.checkApproved(evaluaciones,Integer.parseInt(line[2])));
                    }
                }
            }
        }


    }


    //FINAL ES LA SUMA
    //FOR PRACTICAL WORK
    //FOR ORAL EXAM ONLY ONE GRADE
    //FOR WRITTEN EXAM AVERAGE

}



