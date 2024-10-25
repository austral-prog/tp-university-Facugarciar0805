package com.university.testObjects.testEvaluations;

import com.university.objetos.evaluations.Final;
import com.university.objetos.evaluations.Parcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestFinal {
    @Test
    public void createFinalGetters(){
        Final final1 = new Final("Math", "WRITTEN_EXAM", "final", 7);
        assertEquals("Math", final1.getSubject());
        assertEquals("WRITTEN_EXAM", final1.getEvaluationType());
        assertEquals("final", final1.getEvaluationName());
        assertEquals(7, final1.getTotalMark());
        final1.addGrade(9);
        assertEquals(8, final1.getTotalMark());
    }
    @Test
    public void testEquals(){
        Final final1 = new Final("Math", "WRITTEN_EXAM", "final", 7);
        Final final2 = new Final("Math", "WRITTEN_EXAM", "final", 8);
        Final final3 = new Final("Math", "WRITTEN_EXAM", "tp1", 7);
        Final final4 = new Final("Math", "Oral_exam", "final", 7);
        Final final5 = new Final("Economics", "WRITTEN_EXAM", "final", 7);

        assertTrue(final1.equals(final2));
        assertFalse(final1.equals(final3));
        assertFalse(final1.equals(final4));
        assertFalse(final1.equals(final5));
    }
}
