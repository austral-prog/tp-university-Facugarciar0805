package com.university.aprovedCheckers;

import com.university.objetos.evaluations.Evaluations;


import java.util.List;

public class MinAboveValue implements CheckApproved{
    @Override
    public boolean checkApproved(List<Evaluations> exams, float nota) {
        if(exams.size()==0){
            return false;
        }
        boolean aprobado = true;
        for(Evaluations e: exams){
            if(e.getFinalGrade()< nota){
                aprobado = false;
                break;
            }
        }
        return aprobado;
    }
}
