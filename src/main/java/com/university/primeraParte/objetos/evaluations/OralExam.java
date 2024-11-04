package com.university.primeraParte.objetos.evaluations;

public class OralExam extends Evaluations{
    private int id;
    public OralExam(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }

    @Override
    public float getFinalGrade() {
        return grades.getLast();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
