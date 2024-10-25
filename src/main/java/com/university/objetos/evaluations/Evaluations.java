package com.university.objetos.evaluations;

import com.university.objetos.Creatable;
import com.university.objetos.student.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluations implements Creatable {
    protected String subject;
    protected String evaluationType;
    protected String evaluationName;
    protected List<Float> grades;
    protected Student student;
    public Evaluations(String subject, String evaluationType, String evaluationName, float grade){
        this.subject = subject;
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;
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
    public List<Float> getGrade(){
        return grades;
    }
    public float getTotalMark(){
        float suma=0;
        for(int i=0;i< grades.size();i++){
            suma += grades.get(i);
        }
        return suma/ grades.size();
    }
    public void addGrade(float g){
        grades.add(g);
    }
    public void setStudent(Student s){
        student = s;
    }
    public Student getStudent(){
        return student;
    }
    public String toStringForExpected2(){
        return subject + "," + evaluationName + "," + student.getName() + "," + getTotalMark();
    }
    public boolean equalsAnyEvaluation(Evaluations e){
        if(e != null){
            return e.getSubject().equals(subject)&&
                    e.getEvaluationName().equals(evaluationName)&&
                    e.getEvaluationType().equals(evaluationType);
        }
        else{
            return false;
        }
    }





}
