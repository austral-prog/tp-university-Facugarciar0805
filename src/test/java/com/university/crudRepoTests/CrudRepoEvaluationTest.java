package com.university.crudRepoTests;

import com.university.primeraParte.objetos.Course;
import com.university.primeraParte.objetos.Student;
import com.university.segundaParte.CLILogic.implementations.CrudRepoEvaluation;
import com.university.primeraParte.objetos.evaluations.Evaluations;
import com.university.primeraParte.objetos.evaluations.FinalPracticalWork;
import com.university.primeraParte.objetos.evaluations.OralExam;
import com.university.primeraParte.objetos.evaluations.PraticalWork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CrudRepoEvaluationTest {
    CrudRepoEvaluation crudRepoEvaluation;
    @BeforeEach
    public void setup(){
        crudRepoEvaluation = new CrudRepoEvaluation();
    }

    @Test
    public void testCreate(){
        //One student
        Evaluations evaluations = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "parcial", 5);
        evaluations.setId(1);
        crudRepoEvaluation.create(evaluations);
        assertEquals(evaluations, crudRepoEvaluation.getEntity().get(1));
        //other student
        Evaluations evaluations1 = new OralExam("Economics", "ORAL_EXAM", "TP3", 9);
        evaluations1.setId(2);
        crudRepoEvaluation.create(evaluations1);
        assertEquals(evaluations1, crudRepoEvaluation.getEntity().get(2));

        //same ID
        Evaluations evaluations2 = new PraticalWork("Algebra", "PRACTICAL_WORK", "Examen Final", 7);
        evaluations2.setId(1);
        crudRepoEvaluation.create(evaluations2);
        assertEquals(evaluations, crudRepoEvaluation.getEntity().get(1));
    }
    @Test
    public void testRead(){
        Evaluations evaluations = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "parcial", 5);
        evaluations.setId(1);
        crudRepoEvaluation.create(evaluations);
        assertEquals(evaluations, crudRepoEvaluation.read(1));
    }
    @Test
    public void update(){
        Evaluations evaluations = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "parcial", 5);
        evaluations.setId(1);
        crudRepoEvaluation.create(evaluations);
        Evaluations evaluations2 = new PraticalWork("Algebra", "PRACTICAL_WORK", "Examen Final", 7);
        crudRepoEvaluation.update(1, evaluations2);
        assertEquals("Algebra",crudRepoEvaluation.read(1).getSubject());
        assertEquals("PRACTICAL_WORK",crudRepoEvaluation.read(1).getEvaluationType());
        assertEquals("Examen Final",crudRepoEvaluation.read(1).getEvaluationName());
        assertEquals(7,crudRepoEvaluation.read(1).getFinalGrade());
    }
    @Test
    public void delete(){
        Evaluations evaluations = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "parcial", 5);
        evaluations.setId(1);
        crudRepoEvaluation.create(evaluations);
        crudRepoEvaluation.delete(1);
        assertNull(crudRepoEvaluation.read(1));
    }
    @Test
    public void testGetIdentifier(){
        assertEquals("Evaluation", crudRepoEvaluation.getIdentifier());
    }
    @Test
    public void testEntityClass(){
        assertEquals(Evaluations.class, crudRepoEvaluation.getEntityClass());
    }
    @Test
    public void testGetEntity(){
        Evaluations evaluations = new PraticalWork("Math", "PRACTICAL_WORK", "parcial", 10);
        evaluations.setId(1);
        crudRepoEvaluation.create(evaluations);
        assertEquals(evaluations, crudRepoEvaluation.getEntity().get(1));
    }
}
