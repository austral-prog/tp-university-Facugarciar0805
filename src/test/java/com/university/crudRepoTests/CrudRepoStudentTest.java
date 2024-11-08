package com.university.crudRepoTests;

import com.university.primeraParte.objetos.evaluations.Evaluations;
import com.university.primeraParte.objetos.evaluations.PraticalWork;
import com.university.segundaParte.CLILogic.implementations.CrudRepoStudent;
import com.university.primeraParte.objetos.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CrudRepoStudentTest {

    CrudRepoStudent crudRepoStudent;
    @BeforeEach
    public void setup(){
         crudRepoStudent = new CrudRepoStudent();
    }

    @Test
    public void testCreate(){
        //One student
        Student student = new Student("Facu", "facugarciar@gmail.com");
        student.setId(1);
        crudRepoStudent.create(student);
        assertEquals(student, crudRepoStudent.getEntity().get(1));
        //other student
        Student student2 = new Student("Juan", "juan@gmail.com");
        student2.setId(2);
        crudRepoStudent.create(student2);
        assertEquals(student2, crudRepoStudent.getEntity().get(2));

        //same ID
        Student student3 = new Student("Mati", "Mati@gmail.com");
        student3.setId(1);
        crudRepoStudent.create(student3);
        assertEquals(student, crudRepoStudent.getEntity().get(1));
    }
    @Test
    public void testRead(){
        Student student = new Student("Facu", "facugarciar@gmail.com");
        student.setId(1);
        crudRepoStudent.create(student);
        assertEquals(student, crudRepoStudent.read(1));
    }
    @Test
    public void update(){
        Student student = new Student("Facu", "facugarciar@gmail.com");
        student.setId(1);
        crudRepoStudent.create(student);
        Student student3 = new Student("Mati", "mati@gmail.com");
        crudRepoStudent.update(1, student3);
        assertEquals("Mati",crudRepoStudent.read(1).getName());
        assertEquals("mati@gmail.com",crudRepoStudent.read(1).getMail());
    }
    @Test
    public void delete(){
        Student student = new Student("Facu", "facugarciar@gmail.com");
        student.setId(1);
        crudRepoStudent.create(student);
        crudRepoStudent.delete(1);
        assertNull(crudRepoStudent.read(1));
    }
    @Test
    public void testGetIdentifier(){
        assertEquals("Student", crudRepoStudent.getIdentifier());
    }
    @Test
    public void testEntityClass(){
        assertEquals(Student.class, crudRepoStudent.getEntityClass());
    }
    @Test
    public void testGetEntity(){
        Student student = new Student("facu", "facu@mail.com");
        student.setId(1);
        crudRepoStudent.create(student);
        assertEquals(student, crudRepoStudent.getEntity().get(1));
    }
}
