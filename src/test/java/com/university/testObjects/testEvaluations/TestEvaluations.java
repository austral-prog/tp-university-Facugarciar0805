package com.university.testObjects.testEvaluations;

import com.university.objetos.evaluations.Final;
import com.university.objetos.evaluations.Parcial;
import com.university.objetos.evaluations.TrabajoPractico;
import org.junit.jupiter.api.Test;

import java.nio.file.attribute.FileAttribute;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEvaluations {
    @Test
    public void testGetTotalMark(){
        Parcial p = new Parcial("Math", "WRITTEN", "parcial", 8);
        Final f = new Final("Math", "WRITTEN", "final", 8);
        TrabajoPractico t = new TrabajoPractico("Math", "WRITTEN", "tp1", 8);
        p.addGrade(7);
        p.addGrade(6);
        f.addGrade(7);
        f.addGrade(6);
        t.addGrade(7);
        t.addGrade(6);
        assertEquals(7,p.getTotalMark());
        assertEquals(7,f.getTotalMark());
        assertEquals(7,t.getTotalMark());
    }





}
