package com.university.CsvWorker;

import com.university.student.Student;

import java.util.List;

public class StudentCreator implements ObjectCreator{

    @Override
    public Student createObject(String[] data) {
        Student student = new Student(data[2],data[3]);
        return student;
    }
}
