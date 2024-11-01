package com.university.aprovedCheckers;

import com.university.objetos.evaluations.Evaluations;

import java.util.List;

public class MaxAboveValue implements CheckApproved{
    @Override
    public boolean checkApproved(List<Evaluations> exams, float nota) {
        if(exams.size() == 0){
            return false;
        }
        return nota>exams.getFirst().getFinalGrade();
    }
}
