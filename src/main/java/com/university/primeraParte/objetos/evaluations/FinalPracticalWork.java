package com.university.primeraParte.objetos.evaluations;

public class FinalPracticalWork extends Evaluations{
    private int id;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
