package com.university.testObjects.testEvaluations;

import com.university.objetos.evaluations.TrabajoPractico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTrabajoPractico {
    @Test
    public void testGetters(){
        TrabajoPractico tp1 = new TrabajoPractico("Math", "WRITTEN_EXAM", "tp1", 7);
        assertEquals("Math", tp1.getSubject());
        assertEquals("WRITTEN_EXAM", tp1.getEvaluationType());
        assertEquals("tp1", tp1.getEvaluationName());
        assertEquals(7, tp1.getTotalMark());
        tp1.addGrade(9);
        assertEquals(8, tp1.getTotalMark());
    }
    @Test
    public void testEquals(){
        TrabajoPractico tp1 = new TrabajoPractico("Math", "WRITTEN_EXAM", "tp1", 7);
        TrabajoPractico tp2 = new TrabajoPractico("Math", "WRITTEN_EXAM", "tp1", 8);
        TrabajoPractico tp3 = new TrabajoPractico("Math", "WRITTEN_EXAM", "Parcial", 7);
        TrabajoPractico tp4 = new TrabajoPractico("Math", "Oral_exam", "tp1", 7);
        TrabajoPractico tp5 = new TrabajoPractico("Economics", "WRITTEN_EXAM", "tp1", 7);

        assertTrue(tp1.equals(tp2));
        assertFalse(tp1.equals(tp3));
        assertFalse(tp1.equals(tp4));
        assertFalse(tp1.equals(tp5));
    }
}
