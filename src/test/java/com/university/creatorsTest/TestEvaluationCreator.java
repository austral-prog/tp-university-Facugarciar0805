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
    public void testEvaluationCreator() {
        Student s1 = new Student("Facu", "facu@gmail");
        EvaluationCreator evaluationCreator = new EvaluationCreator();
        String[] linea = {"Alice Cyan", "Computer Science", "FINAL_PRACTICAL_WORK", "TP Final", "Ej3", "7"};
        String[] linea2 = {"Alice Cyan", "Computer Science", "PRACTICAL_WORK", "TP Final", "Ej3", "7"};
        String[] linea3 = {"Alice Cyan", "Computer Science", "ORAL_EXAM", "TP Final", "Ej3", "7"};
        String[] linea4 = {"Alice Cyan", "Computer Science", "WRITTEN_EXAM", "TP Final", "Ej3", "7"};
        Evaluations evaluation = evaluationCreator.createObject(s1.getEvaluations(), linea);
        Evaluations evaluation2 = evaluationCreator.createObject(s1.getEvaluations(), linea2);
        Evaluations evaluation3 = evaluationCreator.createObject(s1.getEvaluations(), linea3);
        Evaluations evaluation4 = evaluationCreator.createObject(s1.getEvaluations(), linea4);
        s1.addEval(evaluation);
        s1.addEval(evaluation2);
        s1.addEval(evaluation3);
        s1.addEval(evaluation4);
        assertEquals(4, s1.getEvaluations().size());
        assertEquals("FINAL_PRACTICAL_WORK", s1.getEvaluations().get(0).getEvaluationType());
        assertEquals("PRACTICAL_WORK", s1.getEvaluations().get(1).getEvaluationType());
        assertEquals("ORAL_EXAM", s1.getEvaluations().get(2).getEvaluationType());
        assertEquals("WRITTEN_EXAM", s1.getEvaluations().get(3).getEvaluationType());
    }
    @Test
    public void testAddSameEvaluation(){
        Student s1 = new Student("Facu", "facu@gmail");
        EvaluationCreator evaluationCreator = new EvaluationCreator();
        String[] linea = {"Alice Cyan", "Computer Science", "FINAL_PRACTICAL_WORK", "TP Final", "Ej3", "7"};
        Evaluations evaluation = evaluationCreator.createObject(s1.getEvaluations(), linea);
        s1.addEval(evaluation);
        evaluation.setStudent(s1);
        s1.addEval(evaluation);
        assertEquals(1, s1.getEvaluations().size());
        assertEquals(2, s1.getEvaluations().getFirst().getGrade().size());
    }
    @Test
    public void testCreateNullEvaluation(){
        Student s1 = new Student("Facu", "facu@gmail");
        EvaluationCreator evaluationCreator = new EvaluationCreator();
        String[] linea = {"Alice Cyan", "Computer Science", "PRACTICAL_EXAM", "TP Final", "Ej3", "7"};
        Evaluations evaluation = evaluationCreator.createObject(s1.getEvaluations(), linea);
        s1.addEval(evaluation);
        assertEquals(0, s1.getEvaluations().size());

    }

}
