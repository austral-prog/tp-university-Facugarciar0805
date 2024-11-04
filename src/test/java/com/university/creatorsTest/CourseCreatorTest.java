package com.university.creatorsTest;
import com.university.primeraParte.creators.course.CourseCreator;
import com.university.primeraParte.objetos.Course;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseCreatorTest {

    @Test
    public void testCreateStudentWithCreator(){
        List<Course> courses = new ArrayList<>();
        CourseCreator courseCreator = new CourseCreator();
        courseCreator.createObject(courses, new String[]{"345","Math","Facundo", "facu@mail", "prof juan"});
        assertEquals(1,courses.size());
        assertEquals("Math", courses.getFirst().getCourseName());
        assertEquals("prof juan", courses.getFirst().getProfessor());
        assertEquals("345", courses.getFirst().getClassNumber());

    }
}
