package com.university.primeraParte.objetos;

import com.university.segundaParte.CLILogic.Entity;
import com.university.primeraParte.objetos.evaluations.Evaluations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Creatable, Entity {
    private String name;
    private List<Course> courses;
    private String mail;
    private List<Evaluations> evaluations;
    private HashMap<String, List<Boolean>> report;
    private int id;

    public Student(String name, String mail){
        this.name= name;
        this.courses = new ArrayList<>();
        this.mail = mail;
        this.evaluations= new ArrayList<>();
        this.report = new HashMap<>();
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
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
    public void setMail(String mail){
        this.mail = mail;
    }
    public boolean equals(Student s){
        return s.getName().equals(name); //&& s.getMail().equals(mail);
    }
    public String toStringForSolutionCsv(){
        return name + "," + courses.size();
    }
    public void addEval(Evaluations evaluation){
        if(evaluation != null){
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
    public List<String> toStringForReport(){
        List<String> lista = new ArrayList<>();
        for (Map.Entry<String, List<Boolean>> entry : report.entrySet()) {
            String key = name + "," + entry.getKey() + ",";
            List<Boolean> value = entry.getValue();
            if (value.contains(false)) {
                key += "Fail";
            } else {
                key += "Pass";
            }
            lista.add(key);
        }
        return lista;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

}
