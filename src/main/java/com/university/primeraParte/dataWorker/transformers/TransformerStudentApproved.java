package com.university.primeraParte.dataWorker.transformers;

import com.university.primeraParte.University;
import com.university.primeraParte.aprovedCheckers.AverageAboveValue;
import com.university.primeraParte.aprovedCheckers.MaxAboveValue;
import com.university.primeraParte.aprovedCheckers.MinAboveValue;
import com.university.primeraParte.objetos.evaluations.Evaluations;
import com.university.primeraParte.objetos.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransformerStudentApproved implements DataTransformer{
    @Override
    public List<String> transform(List<String[]> data, University university) {
        MaxAboveValue maxAboveValue = new MaxAboveValue();
        MinAboveValue minAboveValue = new MinAboveValue();
        AverageAboveValue averageAboveValue = new AverageAboveValue();

        for(Student student: university.getStudentsList()){
            for(String[] line: data){
                if(student.isOnCourse(line[0])){
                    //busco en la lista los TP Finales
                    if(line[3].contains("TP Final")){
                        List<Evaluations> evaluations = new ArrayList<>();
                        for(Evaluations e: student.getEvaluations()){
                            if(e.getSubject().equals(line[0])&& e.getEvaluationName().equals("TP Final")){
                                evaluations.add(e);
                            }
                        }
                        student.addToReport(line[0], maxAboveValue.checkApproved(evaluations,Float.parseFloat(line[2])));
                    }
                    //busco en la lista los TP sin incluir los tp finales
                    else if (line[3].contains("TP")) {
                        List<Evaluations> evaluations = new ArrayList<>();
                        for(Evaluations e: student.getEvaluations()){
                            if(e.getSubject().equals(line[0])&& e.getEvaluationName().contains("TP")&&(!e.getEvaluationName().contains("TP Final"))){
                                evaluations.add(e);
                            }
                        }
                        float nota = Float.parseFloat(line[2]);
                        boolean isApproved = averageAboveValue.checkApproved(evaluations, nota);
                        student.addToReport(line[0], isApproved);
                    }

                    //busco en la lista los finales
                    else if (line[3].contains("Final")) {
                        List<Evaluations> evaluations= new ArrayList<>();
                        for(Evaluations e: student.getEvaluations()){
                            if(e.getSubject().equals(line[0]) && e.getEvaluationName().contains("Final")&&!(e.getSubject().contains("TP Final"))){
                                evaluations.add(e);
                            }
                        }
                        student.addToReport(line[0], maxAboveValue.checkApproved(evaluations,Float.parseFloat(line[2])));
                    }
                    //busco en la lista los parciales
                    else{
                        List<Evaluations> evaluations= new ArrayList<>();
                        for(Evaluations e: student.getEvaluations()){
                            if(e.getSubject().equals(line[0]) && e.getEvaluationName().contains("Parcial")){
                                evaluations.add(e);
                            }
                        }
                        student.addToReport(line[0], minAboveValue.checkApproved(evaluations,Float.parseFloat(line[2])));
                    }

                }
            }
        }

        List<String> reportes = new ArrayList<>();
        for(Student student: university.getStudentsList()){
            reportes.addAll(student.toStringForReport());
        }
        Collections.sort(reportes);
        return reportes;
    }
}
