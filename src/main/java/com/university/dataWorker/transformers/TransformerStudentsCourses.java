package com.university.dataWorker.transformers;

import com.university.University;
import com.university.creators.course.CourseCreator;
import com.university.creators.student.StudentCreator;
import com.university.objetos.course.Course;
import com.university.objetos.student.Student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
