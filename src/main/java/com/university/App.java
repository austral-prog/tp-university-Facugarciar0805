package com.university;

import com.university.CsvWorker.*;
import com.university.course.Course;
import com.university.student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String[]> data = new ArrayList<>();
        List<Student> studentsList = new ArrayList<>();
        List<Course> coursesList = new ArrayList<>();




        CsvReader reader = new CsvReader();
        data = reader.readCsv("src/main/resources/input.csv");

        StudentCreator studentCreator = new StudentCreator();
        CourseCreator courseCreator = new CourseCreator();

        for(int i = 1; i < data.size(); i++){                               //for para toda la data
            Student student = studentCreator.createObject(data.get(i));
            Course course = courseCreator.createObject(data.get(i));

            boolean found = false;

            for (Student s : studentsList) {                       //for para los estudiantes
                if (s.equals(student)) {
                    boolean foundCourse = false;
                    for (Course c : coursesList){                    //for para los cursos
                        if(c.equals(course)){                       //caso: encontre el curso y el estudiante
                            if(!s.containsCourse(c)){
                                s.addCourse(c);
                            }
                            if(!c.containsStudent(s)){
                                c.addStudent(s);
                            }

                            foundCourse = true;
                        }
                    }
                    if(!foundCourse){                               //caso: no encontre el curso pero si el estudiante
                        coursesList.add(course);
                        s.addCourse(course);
                        course.addStudent(s);
                    }
                    found = true;
                }
            }
            if(!found){
                boolean foundCourse = false;
                for (Course c : coursesList){                    //for para los cursos
                    if(c.equals(course)){                       //caso: encontre el curso pero no el estudiante
                        studentsList.add(student);
                        student.addCourse(c);
                        c.addStudent(student);
                        foundCourse = true;
                    }
                }
                if(!foundCourse){                               //caso: no encontre el curso y no encontre el estudiante
                    coursesList.add(course);
                    studentsList.add(student);
                    student.addCourse(course);
                    course.addStudent(student);
                }

            }


        }


        List<Student> lista = getAlphabetical(studentsList);
        List<String> listaSolution = new ArrayList<>();
        for(Student s: lista){
            String elemento = s.getName() + "," + String.valueOf(s.getCoursesAmount());
            listaSolution.add(elemento);
        }
        CsvWriter writer = new CsvWriter("src/main/resources/solution.csv","Student_Name,Course_Count");
        writer.writeCsv(listaSolution);




}


        public static List<Student> getAlphabetical(List<Student> base){
            List<Student> resultado = new ArrayList<>();
            return getAlphabeticalPrivate(base,resultado);
        }
        private static List<Student> getAlphabeticalPrivate(List<Student> base, List<Student> resultado){
            if(base.size()==1){
                resultado.add(base.getFirst());
                return resultado;
            }
            else{
                Student primero = base.getFirst();
                String primera = base.getFirst().getName();
                for (Student student: base){
                    if(student.getName().compareTo(primera)<0){
                        primera = student.getName();
                        primero = student;
                    }
                }
                base.remove(primero);
                resultado.add(primero);
                return getAlphabeticalPrivate(base,resultado);
            }
        }

}

