package com.university.creators;

import com.university.objetos.student.Student;

import java.util.List;

public class StudentCreator implements ObjectCreator<Student> {

    @Override
    public Student createObject(List<Student> lista, String[] data) {
        Student student= new Student(data[2],data[3]);
        for(Student s: lista){
            if(s.equals(student)){
                return s;
            }
        }
        lista.add(student);
        return student;
    }


}
