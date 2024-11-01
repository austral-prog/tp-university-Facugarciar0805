package com.university.dataWorker.transformers;

import com.university.University;
import com.university.creators.evaluation.EvaluationCreator;
import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.student.Student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransformerStudentExams implements DataTransformer{
    @Override
    public List<String> transform(List<String[]> data, University university) {
        EvaluationCreator evaluationCreator = new EvaluationCreator();

        for (String[] linea : data) {
            if (data.indexOf(linea) == 0) {
                continue;
            } else {
                for (Student student : university.getStudentsList()) {
                    if (linea[0].equals(student.getName())) {
                        Evaluations evaluation = evaluationCreator.createObject(student.getEvaluations(), linea);
                        student.addEval(evaluation);
                        evaluation.setStudent(student);
                        break;
                    }
                }
            }
        }

        //Hago una lista total de evaluaciones
        for (Student s : university.getStudentsList()) {
            for (Evaluations e : s.getEvaluations()) {
                university.getEvaluationsList().add(e);
            }
        }
        List<String> listaSolution = new ArrayList<>();
        for (Evaluations e : university.getEvaluationsList()) {
            listaSolution.add(e.toStringForExpected2());
        }
        Collections.sort(listaSolution);
        return listaSolution;
    }
}
