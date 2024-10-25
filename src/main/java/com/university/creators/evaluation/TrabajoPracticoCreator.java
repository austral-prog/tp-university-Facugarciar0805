package com.university.creators.evaluation;


import com.university.creators.ObjectCreator;
import com.university.objetos.evaluations.TrabajoPractico;

import java.util.List;

public class TrabajoPracticoCreator implements ObjectCreator<TrabajoPractico> {
    @Override
    public TrabajoPractico createObject(List<TrabajoPractico> lista, String[] data) {
        TrabajoPractico tp = new TrabajoPractico(data[1], data[2], data[3], Float.valueOf(data[5]));
        for(TrabajoPractico t: lista){
            if(t.equals(tp)){
                t.addGrade(tp.getGrade().getFirst());
                return t;
            }
        }
        return tp;
    }
}
