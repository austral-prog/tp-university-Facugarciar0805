package com.university;

import com.university.CsvWorker.*;
import com.university.Objetos.Creators.CourseCreator;
import com.university.Objetos.Creators.Creatable;
import com.university.Objetos.Creators.ExamCreator;
import com.university.Objetos.Creators.StudentCreator;
import com.university.Objetos.course.Course;
import com.university.Objetos.exams.Exams;
import com.university.Objetos.student.Student;
import com.university.sorter.Sorter;

import java.util.*;

public class App {
    public static void main(String[] args) {

        //variables principales
        List<String[]> dataStudentsExams;
        List<String[]> dataStudentCourses;
        List<Student> studentsList = new ArrayList<>();
        List<Course> coursesList = new ArrayList<>();
        List<Exams> examsList = new ArrayList<>();





        //Creo un lector y meto la info de input.csv en la variable data
        CsvReader reader = new CsvReader();
        dataStudentCourses = reader.readCsv("src/main/resources/input.csv");
        dataStudentsExams = reader.readCsv("src/main/resources/input_2.csv");




        //Inicializo un creador de Students y un creador de cursos
        StudentCreator studentCreator = new StudentCreator();
        CourseCreator courseCreator = new CourseCreator();
        ExamCreator examCreator = new ExamCreator();
        Sorter sorter = new Sorter();


        for(String[] linea: dataStudentCourses){
            if(dataStudentCourses.indexOf(linea)==0){
                continue;
            }
            else{
                Student student= studentCreator.createObject(studentsList,linea);
                Course course = courseCreator.createObject(coursesList,linea);
                student.addCourse(course);
                course.addStudent(student);
            }

        }

        List<String> listaStrings = new ArrayList<>();
        for(Student s: studentsList){
            listaStrings.add(s.toStringForSolutionCsv());
        }

        List<String> solution = sorter.sortStrings(listaStrings);


        //Creo un escritor de csv y escribo el solution.csv
        CsvWriter writer = new CsvWriter();
        writer.writeCsv("src/main/resources/solution.csv","Student_Name,Course_Count",solution);

        //>>>>>>PARTE DOS

        for(String[] linea: dataStudentsExams){
            if(dataStudentsExams.indexOf(linea)!=0) {
                for (Student student : studentsList) {
                    if (linea[0].equals(student.getName())) {
                        Exams exam = examCreator.createObject(student.getExams(), linea);
                        exam.setStudent(student);
                        break;
                    }
                }
            }
        }

            for(Student student: studentsList){
                for(Exams exam: student.getExams()){
                    examsList.add(exam);
                }
            }
            List<String> listaSolution2 = new ArrayList<>();

            for(Exams exams: examsList){
                  listaSolution2.add(exams.toStringForExpected());
            }
            listaSolution2 = sorter.sortStrings(listaSolution2);


        writer.writeCsv("src/main/resources/solution_2.csv","Subject_Name,Evaluation_Name,Student_Name,Grade",listaSolution2);


    }

}

