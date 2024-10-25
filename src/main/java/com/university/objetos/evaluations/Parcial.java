package com.university.objetos.evaluations;

public class Parcial extends Evaluations{
    public Parcial(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }
    public boolean equals(Parcial p) {
        if(p != null){
            return p.getSubject().equals(subject)&&
                    p.getEvaluationName().equals(evaluationName)&&
                    p.getEvaluationType().equals(evaluationType);
        }
        else{
            return false;
        }
    }
}
