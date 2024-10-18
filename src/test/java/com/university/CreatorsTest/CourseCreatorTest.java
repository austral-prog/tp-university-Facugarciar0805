package com.university.CreatorsTest;
import com.university.creators.CourseCreator;
import com.university.objetos.course.Course;
import com.university.objetos.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseCreatorTest {
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
