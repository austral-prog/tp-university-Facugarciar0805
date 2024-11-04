package com.university.testObjects;

import com.university.primeraParte.objetos.Course;
import com.university.primeraParte.objetos.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCourse {
    @Test
    public void testCreateCourse(){
        Course c = new Course("economics","juan", "345");
        assertEquals("economics", c.getCourseName());
        assertEquals("juan", c.getProfessor());
        assertEquals("345", c.getClassNumber());
        assertEquals(0, c.getStudents().size());
    }
    @Test
    public void testAddStudent(){
        Course c = new Course("economics","juan", "345");
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        Student s1 = new Student("Juan", "juangarciar@gmail.com");

        c.addStudent(s);
        c.addStudent(s1);
        assertEquals(2, c.getStudents().size());
    }

    @Test
    public void testEqualsCourses(){
        Course c = new Course("economics","juan", "345");
        Course c2 = new Course("economics","pedro", "234");
        assertTrue(c.equals(c2));

    }
}
