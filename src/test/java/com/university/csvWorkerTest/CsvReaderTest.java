package com.university.csvWorkerTest;
import com.university.csvWorker.CsvReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CsvReaderTest {

    @Test
    public void testReadInput(){
        CsvReader reader = new CsvReader();
        List<String[]> list = reader.readCsv("src/main/resources/input.csv");
        assertEquals(list.get(1)[0],"578");
        assertEquals(list.get(1)[1],"Political Science");
        assertEquals(list.get(1)[2],"Olivia Red");
        assertEquals(list.get(1)[3],"olivia.red@student.org");
        assertEquals(list.get(1)[4],"Prof. Sam");
    }
    @Test
    public void testInput2(){
        CsvReader reader = new CsvReader();
        List<String[]> list = reader.readCsv("src/main/resources/input_2.csv");
        list.remove(list.getFirst());
        int parciales=0;
        int tps=0;
        int finales=0;

        for(String[] linea : list){
            if(linea[3].contains("Parcial")){
                parciales++;
            }
            else if (linea[3].contains("Final")) {
                finales++;
            } else if (linea[3].contains("TP")) {
                tps++;
            }
        }
        assertEquals(131166, parciales + finales + tps);

    }

}
