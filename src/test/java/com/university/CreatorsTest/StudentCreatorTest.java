package com.university.CreatorsTest;
import com.university.creators.StudentCreator;
import com.university.objetos.course.Course;
import com.university.objetos.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentCreatorTest {
    @Test
    public void testCreateStudent(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        assertEquals("Facundo", s.getName());
        assertEquals("facugarciar@gmail.com", s.getMail());
    }
    @Test
    public void testAddCourse(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        Course c = new Course("Computer Science","Prof. Olivia", "533");
        Course c1 = new Course("Math","Prof. Olivia", "533");

        s.addCourse(c);
        s.addCourse(c1);
        assertEquals(2,s.getCourses().size());


    }
    @Test
    public void testAddSameCourse(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        Course c = new Course("Computer Science","Prof. Olivia", "533");
        Course c1 = new Course("Computer Science","Prof. Olivia", "533");
        s.addCourse(c);
        s.addCourse(c1);
        assertEquals(1,s.getCourses().size());


    }
    @Test
    public void testEqualsStudent(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        Student s2 = new Student("Facundo", "tonto");
        assertTrue(s.equals(s2));

    }
    @Test
    public void testCreateStudentWithCreator(){
        List<Student> students = new ArrayList<>();
        StudentCreator studentCreator = new StudentCreator();
        studentCreator.createObject(students, new String[]{"345","Math","Facundo", "facu@mail", "prof juan"});
        assertEquals(1,students.size());
        assertEquals("Facundo", students.getFirst().getName());
        assertEquals("facu@mail", students.getFirst().getMail());

    }
}
