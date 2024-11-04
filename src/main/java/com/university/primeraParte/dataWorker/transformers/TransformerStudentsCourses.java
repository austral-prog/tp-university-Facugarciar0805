package com.university.primeraParte.dataWorker.transformers;

import com.university.primeraParte.University;
import com.university.primeraParte.creators.course.CourseCreator;
import com.university.primeraParte.creators.student.StudentCreator;
import com.university.primeraParte.objetos.Course;
import com.university.primeraParte.objetos.Student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransformerStudentsCourses implements DataTransformer{
    @Override
    public List<String> transform(List<String[]> data, University university) {
        StudentCreator studentCreator = new StudentCreator();
        CourseCreator courseCreator = new CourseCreator();

        for (String[] linea : data) {
            if (data.indexOf(linea) == 0) {
                continue;
            } else {
                Student student = studentCreator.createObject(university.getStudentsList(), linea);
                Course course = courseCreator.createObject(university.getCoursesList(), linea);
                student.addCourse(course);
                course.addStudent(student);
            }
        }
        //Hago una lista de strings para el formato del expected.csv
        List<String> listaStrings = new ArrayList<>();
        for (Student s : university.getStudentsList()) {
            listaStrings.add(s.toStringForSolutionCsv());
        }
        Collections.sort(listaStrings);
        return listaStrings;

    }
}
