package com.university.primeraParte.aprovedCheckers;



import com.university.primeraParte.objetos.evaluations.Evaluations;

import java.util.List;

public class AverageAboveValue implements CheckApproved{

    @Override
    public boolean checkApproved(List<Evaluations> exams, float nota) {
        if(exams.size()==0){
            return false;
        }
        float suma=0;
        float promedio;
        for(Evaluations e : exams){
            suma += e.getFinalGrade();
        }
        promedio = suma/exams.size();
        return promedio > nota;
    }
}
