package com.university.testCheckApproved;

import com.university.aprovedCheckers.MaxAboveValue;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Parcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMaxAboveValue {
    @Test
    public void testMaxAboveValuePass(){
        MaxAboveValue maxAboveValue = new MaxAboveValue();
        Parcial parcial= new Parcial("Math","Written_exam","Parcial",3);
        List<Evaluations> evaluations = new ArrayList<>();
        evaluations.add(parcial);
        assertTrue(maxAboveValue.checkApproved(evaluations,4));
    }
    @Test
    public void testMaxAboveValueFail(){
        MaxAboveValue maxAboveValue = new MaxAboveValue();
        Parcial parcial= new Parcial("Math","Written_exam","Parcial",6);
        List<Evaluations> evaluations = new ArrayList<>();
        evaluations.add(parcial);
        assertFalse(maxAboveValue.checkApproved(evaluations,4));
    }
}




