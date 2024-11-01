package com.university.objetos.evaluations;

public class WrittenExam extends Evaluations{
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
}
