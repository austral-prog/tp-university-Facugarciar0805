package com.university.CsvWorker;

import com.university.course.Course;
import com.university.student.Student;

public class CourseCreator implements ObjectCreator{
    @Override
    public Course createObject(String[] data) {
        Course course = new Course(data[1],data[4], data[0]);
        return course;
    }
}
