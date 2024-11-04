package com.university.primeraParte.creators;

import com.university.primeraParte.objetos.Creatable;

import java.util.List;

public interface ObjectCreator<T extends Creatable>{
    public T createObject(List<T> lista, String[] data);
}
