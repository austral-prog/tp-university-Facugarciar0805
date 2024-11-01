package com.university.objetos.evaluations;

public class PraticalWork extends Evaluations{
    public PraticalWork(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }

    @Override
    public float getFinalGrade() {
        return grades.getLast();
    }
}
