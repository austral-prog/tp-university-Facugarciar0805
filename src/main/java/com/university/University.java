package com.university;

import com.university.objetos.course.Course;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.student.Student;

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
