package com.university.CLILogic.implementations;

import com.university.primeraParte.objetos.Course;

import java.util.HashMap;
import java.util.Map;

public class CrudRepoCourse implements CRUDRepository<Course> {
    private HashMap<Integer, Course> courses;
    public CrudRepoCourse(){
        this.courses = new HashMap<>();
    }
    @Override
    public void create(Course entity) {
        courses.put(entity.getId(), entity);
    }

    @Override
    public Course read(int id) {
        return courses.get(id);
    }

    @Override
    public void update(int id, Course entity) {
        if(courses.containsKey(id)){
            courses.get(id).setProfessor(entity.getProfessor());
            courses.get(id).setClassNumber(entity.getClassNumber());
            courses.get(id).setSubject(entity.getCourseName());
        }
    }

    @Override
    public void delete(int id) {
        courses.remove(id);

    }

    @Override
    public String getIdentifier() {
        return "Course";
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    public void printEntity() {
        for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
            System.out.println("ID: "+entry.getKey()+", Course: " + entry.getValue().getCourseName() + ", " + entry.getValue().getProfessor());
        }
    }
}
