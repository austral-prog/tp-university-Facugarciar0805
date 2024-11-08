package com.university;

import com.university.segundaParte.CLILogic.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInputValidator {
    InputValidator inputValidator;
    @BeforeEach
    public void setup(){
        inputValidator = new InputValidator();
    }
    @Test
    public void testIsValidName(){
        assertTrue(inputValidator.isValidName("Facu"));
        assertFalse(inputValidator.isValidName("facu834"));
    }
    @Test
    public void testIsValidEmail(){
        assertTrue(inputValidator.isValidEmail("facu@mail.com"));
        assertFalse(inputValidator.isValidEmail("facu"));
    }
    @Test
    public void testIsValidSubject(){
        assertTrue(inputValidator.isValidSubject("Algebra 2"));
        assertFalse(inputValidator.isValidSubject("algebra+``"));
    }
    @Test
    public void testIsValidClassNumber(){
        assertTrue(inputValidator.isValidClassNumber("123"));
        assertFalse(inputValidator.isValidClassNumber("12k"));
    }
    @Test
    public void testIsValidGrade(){
        assertTrue(inputValidator.isValidGrade("10.5"));
        assertFalse(inputValidator.isValidGrade("nose"));
    }

}
