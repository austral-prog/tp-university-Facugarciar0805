package com.university.objetos.evaluations;

import com.university.objetos.Creatable;

public class FinalPracticalWork extends Evaluations{
    public FinalPracticalWork(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }

    @Override
    public float getFinalGrade() {
        float suma= 0;
        for(Float grade: grades){
            suma += grade;
        }
        return suma;
    }
}
