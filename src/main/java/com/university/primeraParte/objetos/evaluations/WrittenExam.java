package com.university.primeraParte.objetos.evaluations;

public class WrittenExam extends Evaluations{
    private int id;
    public WrittenExam(String subject, String evaluationType, String evaluationName, float grade) {
        super(subject, evaluationType, evaluationName, grade);
    }
    @Override
    public float getFinalGrade() {
        float suma= 0;
        for(Float grade: grades){
            suma += grade;
        }
        return suma/(grades.size());
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
