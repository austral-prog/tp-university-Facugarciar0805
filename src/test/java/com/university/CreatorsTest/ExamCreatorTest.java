package com.university.CreatorsTest;
import com.university.Objetos.Creators.ExamCreator;
import com.university.Objetos.exams.Exams;
import com.university.Objetos.student.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExamCreatorTest {
    @Test
    public void testCreateExam(){
        Exams exam = new Exams("English",
                        "WRITTEN_EXAM",
                        "Segundo Parcial", "Ej2", 7);
        assertEquals(exam.getSubject(),"English");
        assertEquals(exam.getEvaluationType(),"WRITTEN_EXAM");
        assertEquals(exam.getEvaluationName(),"Segundo Parcial");
        assertEquals(exam.getExerciseNames().getFirst(),"Ej2");
        assertEquals(exam.getGrade().getFirst(),7);
        assertEquals(7,exam.getTotalMark());
    }
    @Test
    public void testGetTotalMarks(){
        Exams exam = new Exams("English",
                "WRITTEN_EXAM",
                "Segundo Parcial", "Ej2", 7);
        exam.addGrade(8);
        exam.addGrade(6);
        assertEquals(7,exam.getTotalMark());
    }
    @Test
    public void testEqualsExam(){
        Exams exam = new Exams("English",
                "WRITTEN_EXAM",
                "Segundo Parcial", "Ej2", 7);
        Exams exam2 = new Exams("English",
                "WRITTEN_EXAM",
                "Segundo Parcial", "Ej3", 8);
        Exams exam3 = new Exams("English",
                "WRITTEN_EXAM",
                "Primer Parcial", "Ej2", 7);
        Exams exam4 = new Exams("Math",
                "WRITTEN_EXAM",
                "Segundo Parcial", "Ej2", 7);

        assertTrue(exam.equals(exam2));
        assertFalse(exam.equals(exam3));
        assertFalse(exam.equals(exam4));
    }
    @Test
    public void testCreateExamWithCreator(){
        List<Exams> examsList = new ArrayList<>();
        ExamCreator examCreator = new ExamCreator();
        examCreator.createObject(examsList, new String[]{"Paul Beige","English","WRITTEN_EXAM","Segundo Parcial","Ej2","7"});
        assertEquals(1, examsList.size());
        assertEquals("English", examsList.getFirst().getSubject());

    }
    @Test void testToStringForExpected2(){
        List<Exams> examsList = new ArrayList<>();
        ExamCreator examCreator = new ExamCreator();
        Student student = new Student("Paul Beige", "paul@mail");
        Exams exams = examCreator.createObject(examsList, new String[]{"Paul Beige","English","WRITTEN_EXAM","Segundo Parcial","Ej2","7"});
        exams.setStudent(student);
        String string = "English,Segundo Parcial,Paul Beige,7";
        assertEquals(string, exams.toStringForExpected());
    }
}
