package com.university.primeraParte.objetos;

import com.university.segundaParte.CLILogic.Entity;

import java.util.ArrayList;
import java.util.List;

public class Course implements Creatable, Entity {
    private String courseName;
    private String professor;
    private List<Student> students;
    private String classNumber;
    private int id;
    public Course(String courseName,String professor, String classNumber){
        this.courseName = courseName;
        this.professor = professor;
        this.classNumber = classNumber;
        this.students = new ArrayList<>();
    }
    public String getProfessor(){
        return professor;
    }
    public void setProfessor(String professor){
        this.professor = professor;
    }
    public String getClassNumber(){
        return classNumber;
    }
    public void setClassNumber(String classNumber){
        this.classNumber = classNumber;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setSubject(String subject){
        this.courseName = subject;
    }
    public List<Student> getStudents(){
        return students;
    }
    public void addStudent(Student s){
        boolean found = false;
        for(Student student:students){
            if(student.equals(s)){
                found = true;
                break;
            }
        }
        if(!found){
            students.add(s);
        }
    }
    public boolean equals(Course c){
        return  c.getCourseName().equals(courseName);
    }
    public boolean containsStudent(Student s){
        return students.contains(s);
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
