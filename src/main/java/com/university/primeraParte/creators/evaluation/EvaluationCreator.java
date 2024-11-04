package com.university.primeraParte.creators.evaluation;

import com.university.primeraParte.creators.ObjectCreator;
import com.university.primeraParte.objetos.evaluations.*;

import java.util.List;

public class EvaluationCreator implements ObjectCreator<Evaluations> {

    @Override
    public Evaluations createObject(List<Evaluations> lista, String[] data) {
        switch(data[2]){
            case "WRITTEN_EXAM":
                return new WrittenExam(data[1], data[2], data[3], Float.parseFloat(data[5]));
            case "FINAL_PRACTICAL_WORK":
                return new FinalPracticalWork(data[1], data[2], data[3], Float.parseFloat(data[5]));
            case "PRACTICAL_WORK":
                return new PraticalWork(data[1], data[2], data[3], Float.parseFloat(data[5]));
            case "ORAL_EXAM":
                return new OralExam(data[1], data[2], data[3], Float.parseFloat(data[5]));
            default:
                return null;
        }

    }
}
