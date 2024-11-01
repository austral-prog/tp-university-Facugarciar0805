package com.university.objetos.evaluations;

public class OralExam extends Evaluations{
    public OralExam(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }

    @Override
    public float getFinalGrade() {
        return grades.getLast();
    }
}
