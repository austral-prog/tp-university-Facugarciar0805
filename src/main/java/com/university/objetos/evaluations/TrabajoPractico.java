package com.university.objetos.evaluations;

public class TrabajoPractico extends Evaluations{
    public TrabajoPractico(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }

    public boolean equals(TrabajoPractico t) {
        if(t != null){
            return t.getSubject().equals(subject)&&
                    t.getEvaluationName().equals(evaluationName)&&
                    t.getEvaluationType().equals(evaluationType);
        }
        else{
            return false;
        }
    }
}
