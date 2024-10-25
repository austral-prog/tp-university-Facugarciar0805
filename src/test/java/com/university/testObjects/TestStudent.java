package com.university.testObjects;

import com.university.objetos.course.Course;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Final;
import com.university.objetos.evaluations.Parcial;
import com.university.objetos.evaluations.TrabajoPractico;
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
    public void testAddEvaluations(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        TrabajoPractico tp1 = new TrabajoPractico("Math", "WRITTEN_EXAM", "tp1", 7);
        Final final1 = new Final("Math", "WRITTEN_EXAM", "final", 7);
        Parcial parcial = new Parcial("Math", "WRITTEN_EXAM", "parcial", 7);
        s.addEvaluation(tp1);
        s.addEvaluation(parcial);
        s.addEvaluation(final1);
        //agego uno de cada
        assertEquals(1, s.getTps().size());
        assertEquals(1, s.getTps().size());
        assertEquals(1, s.getParciales().size());
        //si agrego uno que es igual se tiene que promediar las notas y guardar como uno solo
        s.addEvaluation(tp1);
        s.addEvaluation(parcial);
        s.addEvaluation(final1);
        assertEquals(1, s.getTps().size());
        assertEquals(7,s.getTps().getFirst().getTotalMark());
        assertEquals(1, s.getFinales().size());
        assertEquals(7,s.getFinales().getFirst().getTotalMark());
        assertEquals(1, s.getParciales().size());
        assertEquals(7,s.getParciales().getFirst().getTotalMark());
        assertEquals(3, s.getEvaluations().size());
        //agrego un distinto
    }
    @Test
    public void testAddSameEvaluation(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        TrabajoPractico tp1 = new TrabajoPractico("Math", "WRITTEN_EXAM", "tp1", 7);
        s.addEvaluation(tp1);
        Final final1 = new Final("Math", "WRITTEN_EXAM", "final", 7);
        s.addEvaluation(final1);
        Parcial parcial = new Parcial("Math", "WRITTEN_EXAM", "parcial", 7);
        s.addEvaluation(parcial);
        s.addEvaluation(parcial);
        s.addEvaluation(final1);
        assertEquals(3, s.getEvaluations().size());
        assertEquals(1, s.getTps().size());
        assertEquals(7,s.getTps().getFirst().getTotalMark());
        assertEquals(1, s.getFinales().size());
        assertEquals(7,s.getFinales().getFirst().getTotalMark());
        assertEquals(1, s.getParciales().size());
        assertEquals(7,s.getParciales().getFirst().getTotalMark());
    }
    @Test
    public void testAddMultipleEvaluations(){
        Student s = new Student("Facundo", "facugarciar@gmail.com");
        Evaluations tp1 = new TrabajoPractico("Math", "WRITTEN_EXAM", "tp1", 7);
        Final final1 = new Final("Math", "WRITTEN_EXAM", "final", 7);
        Parcial parcial1 = new Parcial("Math", "WRITTEN_EXAM", "parcial", 7);
        Evaluations tp2 = new TrabajoPractico("Math", "WRITTEN_EXAM", "tp2", 7);
        Final final2 = new Final("Economics", "WRITTEN_EXAM", "final", 7);
        Parcial parcial2 = new Parcial("Physics", "WRITTEN_EXAM", "parcial", 7);
        s.addEvaluation(tp1);
        s.addEvaluation(tp2);
        s.addEvaluation(parcial1);
        s.addEvaluation(parcial2);
        s.addEvaluation(final1);
        s.addEvaluation(final2);
        assertEquals(2,s.getParciales().size());
        assertEquals(2,s.getTps().size());
        assertEquals(2,s.getFinales().size());
        assertEquals(6,s.getEvaluations().size());
    }
    @Test
    public void testAddToReport(){
        Student student = new Student("facu", "facu@gmail");
        student.addToReport("Geography", false);
        assertFalse(student.getReport().get("Geography").getFirst());
    }
}
