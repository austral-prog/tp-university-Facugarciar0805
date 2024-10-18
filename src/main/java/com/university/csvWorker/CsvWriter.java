package com.university.csvWorker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public void writeCsv(String expectedFilePath,String expectedTitle,List<String> listaDatos){
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
