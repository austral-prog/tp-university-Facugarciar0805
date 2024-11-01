package com.university.dataWorker.transformers;

import com.university.University;

import java.util.List;

public interface DataTransformer {
    public List<String> transform(List<String[]> data, University university);
}
