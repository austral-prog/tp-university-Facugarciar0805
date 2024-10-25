package com.university.testCheckApproved;

import com.university.aprovedCheckers.MinAboveValue;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Parcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMinAboveValue {
        @Test
        public void testMaxAboveValuePass(){
            MinAboveValue minAboveValue = new MinAboveValue();
            Parcial parcial= new Parcial("Math","Written_exam","Parcial",6);
            List<Evaluations> evaluations = new ArrayList<>();
            evaluations.add(parcial);
            assertTrue(minAboveValue.checkApproved(evaluations,4));
        }
        @Test
        public void testMaxAboveValueFail(){
            MinAboveValue minAboveValue  = new MinAboveValue();
            Parcial parcial= new Parcial("Math","Written_exam","Parcial",3);
            List<Evaluations> evaluations = new ArrayList<>();
            evaluations.add(parcial);
            assertFalse(minAboveValue.checkApproved(evaluations,4));
        }


}
