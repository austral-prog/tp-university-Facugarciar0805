package com.university.testCheckApproved;

import com.university.primeraParte.aprovedCheckers.MinAboveValue;
import com.university.primeraParte.objetos.evaluations.Evaluations;
import com.university.primeraParte.objetos.evaluations.FinalPracticalWork;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMinAboveValue {
        @Test
        public void testMinAboveValuePass(){
            MinAboveValue minAboveValue = new MinAboveValue();
            List<Evaluations> evaluations = new ArrayList<>();
            Evaluations e1 = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "TP3", 5);
            evaluations.add(e1);
            assertTrue(minAboveValue.checkApproved(evaluations, 4));
            Evaluations e2 = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "TP2", 6);
            evaluations.add(e2);
            assertTrue(minAboveValue.checkApproved(evaluations,4));
            Evaluations e3 = new FinalPracticalWork("Math", "FINAL_PRACTICAL_WORK", "TP1", 3);
            evaluations.add(e3);
            assertFalse(minAboveValue.checkApproved(evaluations,4));
        }

}
