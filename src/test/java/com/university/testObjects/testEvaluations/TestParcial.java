package com.university.testObjects.testEvaluations;

import com.university.objetos.evaluations.Parcial;
import com.university.objetos.evaluations.TrabajoPractico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestParcial {
    @Test
    public void testGetters(){
        Parcial parcial = new Parcial("Math", "WRITTEN_EXAM", "primer parcial", 7);
        assertEquals("Math", parcial.getSubject());
        assertEquals("WRITTEN_EXAM", parcial.getEvaluationType());
        assertEquals("primer parcial", parcial.getEvaluationName());
        assertEquals(7, parcial.getTotalMark());
        parcial.addGrade(9);
        assertEquals(8, parcial.getTotalMark());
    }
    @Test
    public void testEquals(){
        Parcial parcial1 = new Parcial("Math", "WRITTEN_EXAM", "parcial", 7);
        Parcial parcial2 = new Parcial("Math", "WRITTEN_EXAM", "parcial", 8);
        Parcial parcial3 = new Parcial("Math", "WRITTEN_EXAM", "tp1", 7);
        Parcial parcial4 = new Parcial("Math", "Oral_exam", "parcial", 7);
        Parcial parcial5 = new Parcial("Economics", "WRITTEN_EXAM", "parcial", 7);

        assertTrue(parcial1.equals(parcial2));
        assertFalse(parcial1.equals(parcial3));
        assertFalse(parcial1.equals(parcial4));
        assertFalse(parcial1.equals(parcial5));
    }
}
