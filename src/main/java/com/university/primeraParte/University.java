package com.university.primeraParte;

import com.university.primeraParte.objetos.Course;
import com.university.primeraParte.objetos.evaluations.Evaluations;
import com.university.primeraParte.objetos.Student;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> studentsList;
    private List<Course> coursesList;
    private List<Evaluations> evaluationsList;
    public University(){
        this.studentsList = new ArrayList<>();
        this.coursesList = new ArrayList<>();
        this.evaluationsList = new ArrayList<>();
    }
    public List<Student> getStudentsList(){
        return studentsList;
    }
    public List<Course> getCoursesList(){
        return coursesList;
    }
    public List<Evaluations> getEvaluationsList(){
        return evaluationsList;
    }

}
