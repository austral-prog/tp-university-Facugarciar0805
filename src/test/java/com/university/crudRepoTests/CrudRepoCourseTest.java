package com.university.crudRepoTests;

import com.university.segundaParte.CLILogic.implementations.CrudRepoCourse;
import com.university.primeraParte.objetos.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CrudRepoCourseTest {
    CrudRepoCourse crudRepoCourse;
    @BeforeEach
    public void setup(){
        crudRepoCourse = new CrudRepoCourse();
    }

    @Test
    public void testCreate(){
        //One Course
        Course course = new Course("Math", "juan", "876");
        course.setId(1);
        crudRepoCourse.create(course);
        assertEquals(course, crudRepoCourse.getEntity().get(1));

        //other course
        Course course2 = new Course("Economics", "facu", "756");
        course2.setId(2);
        crudRepoCourse.create(course2);
        assertEquals(course2, crudRepoCourse.getEntity().get(2));

        //same ID
        Course course3 = new Course("Algebra", "pablo", "875");
        course3.setId(1);
        crudRepoCourse.create(course3);
        assertEquals(course, crudRepoCourse.getEntity().get(1));
    }
    @Test
    public void testRead(){
        Course course = new Course("Math", "juan", "876");
        course.setId(1);
        crudRepoCourse.create(course);
        assertEquals(course, crudRepoCourse.read(1));
    }
    @Test
    public void update(){
        Course course = new Course("Math", "juan", "876");
        course.setId(1);
        crudRepoCourse.create(course);
        Course course3 = new Course("Algebra", "pablo", "875");
        crudRepoCourse.update(1, course3);
        assertEquals("Algebra",crudRepoCourse.read(1).getCourseName());
        assertEquals("pablo",crudRepoCourse.read(1).getProfessor());
        assertEquals("875",crudRepoCourse.read(1).getClassNumber());
    }
    @Test
    public void delete(){
        Course course = new Course("Math", "juan", "876");
        course.setId(1);
        crudRepoCourse.create(course);
        crudRepoCourse.delete(1);
        assertNull(crudRepoCourse.read(1));
    }
    @Test
    public void testGetIdentifier(){
        assertEquals("Course", crudRepoCourse.getIdentifier());
    }
    @Test
    public void testEntityClass(){
        assertEquals(Course.class, crudRepoCourse.getEntityClass());
    }
    @Test
    public void testGetEntity(){
        Course course = new Course("Math", "juan", "876");
        course.setId(1);
        crudRepoCourse.create(course);
        assertEquals(course, crudRepoCourse.getEntity().get(1));
    }

}
