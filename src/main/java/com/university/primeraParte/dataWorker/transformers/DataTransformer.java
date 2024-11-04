package com.university.primeraParte.dataWorker.transformers;

import com.university.primeraParte.University;

import java.util.List;

public interface DataTransformer {
    public List<String> transform(List<String[]> data, University university);
}
