package com.university.objetos.evaluations;

public class Final extends Evaluations{
    public Final(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }


    public boolean equals(Final f) {
        if(f != null){
            return f.getSubject().equals(subject)&&
                    f.getEvaluationName().equals(evaluationName)&&
                    f.getEvaluationType().equals(evaluationType);
        }
        else{
            return false;
        }
    }

}
