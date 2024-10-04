package com.university.student;

import com.university.CsvWorker.Creatable;
import com.university.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student implements Creatable {
    private String name;
    private List<Course> courses;
    private String mail;

    public Student(String name, String mail){
        this.name= name;
        this.courses = new ArrayList<>();
        this.mail = mail;
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
        courses.add(c);
    }
    public String getMail(){
        return mail;
    }
    public boolean equals(Student s){
        return s.getName().equals(name); //&& s.getMail().equals(mail);
    }
    public boolean containsCourse(Course c){
        return courses.contains(c);
    }
}
