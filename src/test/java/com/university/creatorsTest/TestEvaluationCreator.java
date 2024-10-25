package com.university.creatorsTest;

import com.university.creators.evaluation.EvaluationCreator;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.student.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import java.util.List;

public class TestEvaluationCreator {
    @Test
    public void testEvaluationCreator(){
        Student s1= new Student("Facu", "facu@gmail");
        String[] linea = {"Facu","Math", "Written", "Parcial", "ej1", "10" };
        String[] linea2 = {"Facu","Math", "Written", "Final", "ej1", "10" };
        String[] linea3 = {"Facu","Math", "Written", "TP1", "ej1", "10" };
        EvaluationCreator evaluationCreator = new EvaluationCreator();
        Evaluations e1 = evaluationCreator.createEvaluations(s1, linea);
        Evaluations e2 = evaluationCreator.createEvaluations(s1, linea2);
        Evaluations e3 = evaluationCreator.createEvaluations(s1, linea3);
        s1.addEvaluation(e1);
        s1.addEvaluation(e2);
        s1.addEvaluation(e3);
        e1.setStudent(s1);
        e2.setStudent(s1);
        e3.setStudent(s1);
        assertEquals(3,s1.getEvaluations().size());
        assertEquals(1, s1.getParciales().size());
        assertEquals(1, s1.getTps().size());
        assertEquals(1,s1.getFinales().size());
    }
    @Test
    public void testAddGradesWithCreator(){
        Student s1= new Student("Facu", "facu@gmail");
        String[] linea = {"Facu","Math", "Written", "Parcial", "ej1", "10" };
        String[] linea2 = {"Facu","Math", "Written", "Parcial", "ej2", "9" };
        String[] linea3 = {"Facu","Math", "Written", "Parcial", "ej3", "2" };
        EvaluationCreator evaluationCreator = new EvaluationCreator();
        Evaluations e1 = evaluationCreator.createEvaluations(s1, linea);
        s1.addEvaluation(e1);
        Evaluations e2 = evaluationCreator.createEvaluations(s1, linea2);
        s1.addEvaluation(e2);
        Evaluations e3 = evaluationCreator.createEvaluations(s1, linea3);
        s1.addEvaluation(e3);
        e1.setStudent(s1);
        e2.setStudent(s1);
        e3.setStudent(s1);
        assertEquals(1,s1.getEvaluations().size());
        assertEquals(1, s1.getParciales().size());
        assertEquals(7, s1.getParciales().getFirst().getTotalMark());
    }
}
