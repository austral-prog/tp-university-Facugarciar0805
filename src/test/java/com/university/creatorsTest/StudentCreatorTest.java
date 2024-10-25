package com.university.creatorsTest;
import com.university.creators.student.StudentCreator;
import com.university.objetos.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentCreatorTest {

    @Test
    public void testCreateStudentWithCreator(){
        List<Student> students = new ArrayList<>();
        StudentCreator studentCreator = new StudentCreator();
        studentCreator.createObject(students, new String[]{"345","Math","Facundo", "facu@mail", "prof juan"});
        assertEquals(1,students.size());
        assertEquals("Facundo", students.getFirst().getName());
        assertEquals("facu@mail", students.getFirst().getMail());

    }
}
