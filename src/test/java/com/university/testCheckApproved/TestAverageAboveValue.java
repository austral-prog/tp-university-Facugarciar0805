package com.university.testCheckApproved;
import com.university.aprovedCheckers.AverageAboveValue;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Parcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestAverageAboveValue {
    @Test
    public void testAverageAboveValueFail(){
        AverageAboveValue averageAboveValue = new AverageAboveValue();
        Parcial parcial1= new Parcial("Math","Written_exam","Parcial",2);
        Parcial parcial2= new Parcial("Math","Written_exam","Parcial 2", 5);
        List<Evaluations> evaluations = new ArrayList<>();
        evaluations.add(parcial1);
        evaluations.add(parcial1);
        assertFalse(averageAboveValue.checkApproved(evaluations,4));
    }
    @Test
    public void testAverageAboveValuePass(){
        AverageAboveValue averageAboveValue = new AverageAboveValue();
        Parcial parcial= new Parcial("Math","Written_exam","Parcial",7);
        Parcial parcial1= new Parcial("Math","Written_exam","Parcial 2", 5);
        List<Evaluations> evaluations = new ArrayList<>();
        evaluations.add(parcial1);
        evaluations.add(parcial);
        assertTrue(averageAboveValue.checkApproved(evaluations,4));
    }
}
