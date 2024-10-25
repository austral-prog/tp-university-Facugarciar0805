package com.university.creators;

import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Final;
import com.university.objetos.evaluations.Parcial;
import com.university.objetos.evaluations.TrabajoPractico;

import java.util.List;

public class EvaluationCreator2 implements ObjectCreator<Evaluations> {
    @Override
    public Evaluations createObject(List<Evaluations> lista, String[] data) {
        if(data[3].contains("Parcial")){
            Parcial parcial = new Parcial(data[1], data[2], data[3], Float.valueOf(data[5]));
            return parcial;
        } else if (data[3].contains("TP")) {
            TrabajoPractico tp = new TrabajoPractico(data[1], data[2], data[3], Float.valueOf(data[5]));
            return tp;
        }else{
            Final final1 = new Final(data[1], data[2], data[3], Float.valueOf(data[5]));
            return final1;
        }
    }
}
