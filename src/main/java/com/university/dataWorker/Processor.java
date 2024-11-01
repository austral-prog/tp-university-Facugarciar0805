package com.university.dataWorker;

import com.university.University;
import com.university.csvWorker.CsvReader;
import com.university.csvWorker.CsvWriter;
import com.university.dataWorker.transformers.DataTransformer;

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
