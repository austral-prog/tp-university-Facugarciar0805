package com.university.sorterTest;
import com.university.sorter.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SorterTest {
    Sorter sorter;
    @BeforeEach
    public void setUp(){
        sorter = new Sorter();
    }
    @Test
    public void testSorter(){
        List<String> lista = new ArrayList<>(Arrays.asList("hola", "chau","fefo"));
        List<String> listaNueva = sorter.sortStrings(lista);
        System.out.println(listaNueva);
        assertEquals("chau", listaNueva.getFirst());
        assertEquals("hola", listaNueva.getLast());

    }
}
