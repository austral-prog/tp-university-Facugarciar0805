package com.university.testObjects;

import com.university.objetos.course.Course;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.student.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudent {
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
    public void testIsOnCourse(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        Course c = new Course("Computer Science","Prof. Olivia", "533");
        s.addCourse(c);
        assertTrue(s.isOnCourse("Computer Science"));
        assertFalse(s.isOnCourse("Math"));


    }
    @Test
    public void testEqualsStudent(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        Student s2 = new Student("Facundo", "tonto");
        assertTrue(s.equals(s2));

    }
    @Test
    public void testToStringForSolutionCSV(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        assertEquals("Facundo,0", s.toStringForSolutionCsv());
    }
    @Test
    public void testAddEval(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");

    }
    @Test
    public void testAddSameEvaluation(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");

    }
    @Test
    public void testAddMultipleEvaluations(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");

    }
    @Test
    public void testAddToReport(){
        Student student = new Student("facu", "facu@gmail");
        student.addToReport("Geography", false);
        assertFalse(student.getReport().get("Geography").getFirst());
        student.addToReport("Math", true);
        assertTrue(student.getReport().get("Math").getFirst());
    }

    @Test
    public void testToStringForReport(){
        Student student = new Student("facu", "facu@gmail");
        student.addToReport("Geography", false);
        student.addToReport("Math", true);
        assertEquals("facu,Geography,Fail", student.toStringForReport().getFirst());
        assertEquals("facu,Math,Pass", student.toStringForReport().getLast());
    }

}
