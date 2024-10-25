package com.university.aprovedCheckers;

import com.university.objetos.evaluations.Evaluations;

import java.util.List;

public class MaxAboveValue implements CheckApproved{
    @Override
    public boolean checkApproved(List<Evaluations> exams, int nota) {
        return nota>exams.getFirst().getTotalMark();
    }
}
