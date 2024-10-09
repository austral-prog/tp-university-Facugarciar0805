package com.university.Objetos.Creators;


import com.university.Objetos.exams.Exams;
import com.university.Objetos.student.Student;

import java.util.List;

public class ExamCreator implements ObjectCreator<Exams>{

    @Override
    public Exams createObject(List<Exams> lista, String[] data) {
        Exams exam = new Exams(data[1], data[2], data[3], data[4], Integer.valueOf(data[5]));
        for(Exams e: lista){
            if(e.equals(exam)){
                e.addGrade(exam.getGrade().getFirst());
                e.addExerciseName(exam.getExerciseNames().getFirst());
                return e;
            }
        }
        lista.add(exam);
        return exam;
    }
}
