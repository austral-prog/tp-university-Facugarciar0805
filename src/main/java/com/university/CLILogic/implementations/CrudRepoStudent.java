package com.university.CLILogic.implementations;

import com.university.primeraParte.objetos.Course;
import com.university.primeraParte.objetos.Student;

import java.util.HashMap;
import java.util.Map;

public class CrudRepoStudent implements CRUDRepository<Student> {
    private HashMap<Integer, Student> students;
    public CrudRepoStudent(){
        this.students = new HashMap<>();
    }
    @Override
    public void create(Student entity) {
        if(!students.containsKey(entity.getId())){
            students.put(entity.getId(),entity);
        }
    }

    @Override
    public Student read(int id) {
        if(students.containsKey(id)){
            return students.get(id);
        }
        else{
            return null;
        }
    }

    @Override
    public void update(int id, Student entity) {
        if(students.containsKey(id)){
            students.get(id).setName(entity.getName());
            students.get(id).setMail(entity.getMail());
        }

    }
    @Override
    public void delete(int id) {
        students.remove(id);
    }

    @Override
    public String getIdentifier() {
        return "Student";
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public void printEntity() {
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            System.out.println("ID: "+entry.getKey()+", Student: " + entry.getValue().getName() + ", " + entry.getValue().getMail());
        }
    }
}
