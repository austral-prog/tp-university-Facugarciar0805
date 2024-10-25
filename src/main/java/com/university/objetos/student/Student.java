package com.university.objetos.student;

import com.university.objetos.Creatable;
import com.university.objetos.course.Course;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Final;
import com.university.objetos.evaluations.Parcial;
import com.university.objetos.evaluations.TrabajoPractico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student implements Creatable {
    private String name;
    private List<Course> courses;
    private String mail;
    private List<TrabajoPractico> tps;
    private List<Final> finales;
    private List<Parcial> parciales;
    private List<Evaluations> evaluations;
    private HashMap<String, List<Boolean>> report;

    public Student(String name, String mail){
        this.name= name;
        this.courses = new ArrayList<>();
        this.mail = mail;
        this.tps = new ArrayList<>();
        this.finales = new ArrayList<>();
        this.parciales = new ArrayList<>();
        this.evaluations= new ArrayList<>();
        this.report = new HashMap<>();
    }
    public String getName(){
        return name;
    }
    public int getCoursesAmount(){
        return courses.size();
    }
    public List<Course> getCourses(){
        return courses;
    }
    public void addCourse(Course c){
        boolean found = false;
        for(Course course: courses){
            if(course.equals(c)){
                found = true;
                break;
            }
        }
        if(!found){
            courses.add(c);
        }


    }
    public String getMail(){
        return mail;
    }
    public boolean equals(Student s){
        return s.getName().equals(name); //&& s.getMail().equals(mail);
    }
    public String toStringForSolutionCsv(){
        return name + "," + courses.size();
    }
    public void addEvaluation(Evaluations evaluation) {
        if (evaluation instanceof TrabajoPractico) {
            boolean exists = false;
            for (TrabajoPractico tp : tps) {
                if (tp.equals((TrabajoPractico) evaluation)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                tps.add((TrabajoPractico) evaluation);
            }

        }
        else if (evaluation instanceof Final) {
            boolean exists = false;
            for (Final f : finales) {
                if (f.equals((Final) evaluation)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                finales.add((Final) evaluation);

            }

        }
        else if (evaluation instanceof Parcial) {
            boolean exists = false;
            for (Parcial p : parciales) {
                if (p.equals((Parcial) evaluation)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                parciales.add((Parcial) evaluation);

            }
        }

        boolean found=false;
        for(Evaluations e: evaluations){
            if(evaluation.equalsAnyEvaluation(e)){
                found = true;
                break;
            }
        }
        if(!found){
            evaluations.add(evaluation);
        }
    }
    public void addEval(Evaluations evaluation){
        boolean exists = false;
        for(Evaluations e: evaluations){
           if(e.equalsAnyEvaluation(evaluation)) {
               e.addGrade(evaluation.getGrade().getFirst());
               exists = true;
               break;
           }
        }
        if(!exists){
            evaluations.add(evaluation);
        }
    }
    public List<TrabajoPractico> getTps(){
        return tps;
    }
    public List<Final> getFinales(){
        return finales;
    }
    public List<Parcial> getParciales(){
        return parciales;
    }
    public List<Evaluations> getEvaluations(){
        return evaluations;
    }
    public boolean isOnCourse(String c){
        for(Course course: courses){
            if(course.getCourseName().equals(c)){
                return true;
            }
        }
        return false;
    }
    public HashMap<String, List<Boolean>> getReport(){
        return report;
    }
    public void addToReport(String materia, boolean b){
        if (report.containsKey(materia)) {
            // Add the number to the existing list
            report.get(materia).add(b);
        } else {
            // Create a new list and add the number, then put it in the map
            List<Boolean> newList = new ArrayList<>();
            newList.add(b);
            report.put(materia, newList);
        }
    }


}
