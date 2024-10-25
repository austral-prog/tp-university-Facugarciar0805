package com.university.creators.evaluation;

import com.university.creators.ObjectCreator;
import com.university.objetos.evaluations.Final;


import java.util.List;

public class FinalCreator implements ObjectCreator<Final> {
    @Override
    public Final createObject(List<Final> lista, String[] data) {
        Final final1 = new Final(data[1], data[2], data[3], Float.valueOf(data[5]));
        for(Final f: lista){
            if(f.equals(final1)){
                f.addGrade(final1.getTotalMark());
                return f;
            }
        }
        return final1;
    }
}
