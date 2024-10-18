package com.university.objetos.student;

import com.university.creators.Creatable;
import com.university.objetos.course.Course;
import com.university.objetos.exams.Exams;

import java.util.ArrayList;
import java.util.List;

public class Student implements Creatable {
    private String name;
    private List<Course> courses;
    private String mail;
    private List<Exams> exams;

    public Student(String name, String mail){
        this.name= name;
        this.courses = new ArrayList<>();
        this.mail = mail;
        this.exams= new ArrayList<>();
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
    public List<Exams> getExams(){
        return exams;
    }
    public void addExam(Exams e){
        exams.add(e);
    }
}
