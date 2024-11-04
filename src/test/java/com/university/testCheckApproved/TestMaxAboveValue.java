package com.university.testCheckApproved;

import com.university.primeraParte.aprovedCheckers.MaxAboveValue;
import com.university.primeraParte.objetos.evaluations.Evaluations;
import com.university.primeraParte.objetos.evaluations.FinalPracticalWork;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMaxAboveValue {
    @Test
    public void testMaxAboveValuePass(){
        MaxAboveValue maxAboveValue = new MaxAboveValue();
        List<Evaluations> evaluations = new ArrayList<>();
        Evaluations e1 = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "TP3", 3);
        evaluations.add(e1);
        assertTrue(maxAboveValue.checkApproved(evaluations, 4));
    }
    @Test
    public void testMaxAboveValueNoEvaluation(){
        MaxAboveValue maxAboveValue = new MaxAboveValue();
        List<Evaluations> evaluations = new ArrayList<>();
        assertFalse(maxAboveValue.checkApproved(evaluations, 5));
    }

}




