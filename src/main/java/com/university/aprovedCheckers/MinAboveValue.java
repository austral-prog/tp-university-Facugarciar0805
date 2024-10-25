package com.university.aprovedCheckers;

import com.university.objetos.evaluations.Evaluations;


import java.util.List;

public class MinAboveValue implements CheckApproved{
    @Override
    public boolean checkApproved(List<Evaluations> exams, int nota) {
        return exams.getFirst().getTotalMark()>nota;
    }
}
