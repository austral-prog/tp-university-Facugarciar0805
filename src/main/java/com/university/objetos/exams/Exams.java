package com.university.objetos.exams;

import com.university.creators.Creatable;
import com.university.objetos.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Exams implements Creatable {
    String subject;
    String evaluationType;
    String evaluationName;
    List<String> exerciseNames;
    List<Integer> grades;
    Student student;
    public Exams(String subject, String evaluationType, String evaluationName, String exerciseName, int grade){
        this.subject = subject;
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;
        this.exerciseNames = new ArrayList<>();
        exerciseNames.add(exerciseName);
        this.grades = new ArrayList<>();
        grades.add(grade);
    }
    public String getSubject(){
        return subject;
    }
    public String getEvaluationType(){
        return evaluationType;
    }
    public String getEvaluationName(){
        return evaluationName;
    }
    public List<String> getExerciseNames(){
        return exerciseNames;
    }
    public void addExerciseName(String s){
        exerciseNames.add(s);
    }
    public List<Integer> getGrade(){
        return grades;
    }
    public int getTotalMark(){
        int suma=0;
        for(int i=0;i< grades.size();i++){
            suma += grades.get(i);
        }
        return suma/ grades.size();
    }
    public void addGrade(int g){
        grades.add(g);
    }
    public boolean equals(Exams e){
        if(e != null){
            return e.getSubject().equals(subject)&&
                    e.getEvaluationName().equals(evaluationName)&&
                    e.getEvaluationType().equals(evaluationType);
        }
        else{
            return false;
        }

    }
    public void setStudent(Student s){
        student = s;
    }
    public Student getStudent(){
        return student;
    }
    public String toStringForExpected(){
        return subject + "," + evaluationName + "," + student.getName() + "," + getTotalMark();
    }



}
