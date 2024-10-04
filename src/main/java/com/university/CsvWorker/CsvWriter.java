package com.university.CsvWorker;

import com.university.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    private String expectedFilePath;
    private String expectedTitle;
    public CsvWriter(String expectedFilePath,String expectedTitle){
        this.expectedFilePath = expectedFilePath;
        this.expectedTitle = expectedTitle;
    }
    public void writeCsv(List<String> listaDatos){
        try(FileWriter writer = new FileWriter(expectedFilePath)){
            writer.append(expectedTitle)
                    .append("\n");
            for(String string: listaDatos){
                writer.append(string)
                        .append("\n");
            }
            writer.append("\n");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
