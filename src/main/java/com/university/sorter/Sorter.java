package com.university.sorter;

import com.university.Objetos.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Sorter {
    public List<String> sortStrings(List<String> base){
        List<String> resultado = new ArrayList<>();
        return privateSortStrings(new ArrayList<>(base), resultado);
    }
    private List<String> privateSortStrings(List<String> base,List<String> resultado){
        if(base.size()==1){
            resultado.add(base.getFirst());
            return resultado;
        }
        else{
            String primero = base.getFirst();
            for (String string: base){
                if(string.compareTo(primero)<0){
                    primero = string;
                }
            }
            base.remove(primero);
            resultado.add(primero);
            return privateSortStrings(base,resultado);
        }
    }
}
