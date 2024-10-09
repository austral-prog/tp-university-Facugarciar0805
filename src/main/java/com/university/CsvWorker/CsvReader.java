package com.university.CsvWorker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private String line;
    private String splitBy;
    private BufferedReader bufferedRead;
    public CsvReader(){
        this.line = "";
        this.splitBy = ",";
        this.bufferedRead = null;
    }


    public List<String[]> readCsv(String filePath){
        List<String[]> data = new ArrayList<>();
        try {
            bufferedRead = new BufferedReader(new FileReader(filePath));
            while(true){
                try{
                    if((line = bufferedRead.readLine()) == null)break;
                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }
                String[] values = line.split(splitBy);
                data.add(values);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
