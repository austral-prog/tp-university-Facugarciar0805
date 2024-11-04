package com.university.primeraParte.creators.course;

import com.university.primeraParte.creators.ObjectCreator;
import com.university.primeraParte.objetos.Course;

import java.util.List;

public class CourseCreator implements ObjectCreator<Course> {

    @Override
    public Course createObject(List<Course> lista, String[] data) {
        Course course= new Course(data[1],data[4], data[0]);
        for(Course c: lista){
            if(c.equals(course)){
                return c;
            }
        }
        lista.add(course);
        return course;
    }
}
