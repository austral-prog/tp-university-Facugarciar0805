package com.university.creators;

import java.util.List;

public interface ObjectCreator<T extends Creatable>{
    public T createObject(List<T> lista, String[] data);
}
