package com.university.primeraParte.dataWorker;

import com.university.primeraParte.University;
import com.university.primeraParte.csvWorker.CsvReader;
import com.university.primeraParte.csvWorker.CsvWriter;
import com.university.primeraParte.dataWorker.transformers.DataTransformer;

import java.util.List;

public class Processor {
    private CsvReader reader;
    private CsvWriter writer;
    private DataTransformer transformer;
    public Processor(DataTransformer transformer){
        this.reader = new CsvReader();
        this.writer = new CsvWriter();
        this.transformer = transformer;
    }
    public void processData(String inputPath, String solutionPath, String solutionTitle, University university){
        List<String[]> dataStudentCourses = reader.readCsv(inputPath);
        List<String> solution = transformer.transform(dataStudentCourses, university);
        writer.writeCsv(solutionPath, solutionTitle, solution);

    }
}
