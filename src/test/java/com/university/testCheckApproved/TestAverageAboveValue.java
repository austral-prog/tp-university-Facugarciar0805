package com.university.testCheckApproved;
import com.university.aprovedCheckers.AverageAboveValue;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.FinalPracticalWork;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestAverageAboveValue {
    @Test
    public void testAverageAboveValuePass(){
        AverageAboveValue averageAboveValue = new AverageAboveValue();
        List<Evaluations> evaluations = new ArrayList<>();
        Evaluations e1 = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "TP3", 5);
        evaluations.add(e1);
        Evaluations e2 = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "TP2", 7);
        evaluations.add(e2);
        assertTrue(averageAboveValue.checkApproved(evaluations, 5));
        Evaluations e3 = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "TP1", 1);
        evaluations.add(e3);
        assertFalse(averageAboveValue.checkApproved(evaluations, 5));
    }
    @Test
    public void testAverageAboveValueNoEvaluation(){
        AverageAboveValue averageAboveValue = new AverageAboveValue();
        List<Evaluations> evaluations = new ArrayList<>();
        assertFalse(averageAboveValue.checkApproved(evaluations, 5));
    }
}
