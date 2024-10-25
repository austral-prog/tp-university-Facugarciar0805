package com.university.creators.evaluation;


import com.university.creators.ObjectCreator;
import com.university.objetos.evaluations.Parcial;

import java.util.List;

public class ParcialCreator implements ObjectCreator<Parcial> {
    @Override
    public Parcial createObject(List<Parcial> lista, String[] data) {
        Parcial parcial = new Parcial(data[1], data[2], data[3], Float.valueOf(data[5]));
        for(Parcial p: lista){
            if(p.equals(parcial)){
                p.addGrade(parcial.getGrade().getFirst());
                return p;
            }
        }
        return parcial;
    }
}
