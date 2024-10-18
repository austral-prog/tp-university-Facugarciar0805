package com.university.CsvWorkerTest;
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

}
