package com.university.objetos.course;

import com.university.objetos.Creatable;
import com.university.objetos.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Course implements Creatable {
    private String courseName;
    private String professor;
    private List<Student> students;
    String classNumber;
    public Course(String courseName,String professor, String classNumber){
        this.courseName = courseName;
        this.professor = professor;
        this.classNumber = classNumber;
        this.students = new ArrayList<>();

    }
    public String getProfessor(){
        return professor;
    }
    public String getClassNumber(){
        return classNumber;
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
    public String getCourseName(){
        return courseName;
    }
    public boolean equals(Course c){
        return  c.getCourseName().equals(courseName);
    }
    public boolean containsStudent(Student s){
        return students.contains(s);
    }

}
