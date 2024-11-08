package com.university.segundaParte.CLILogic;

public class InputValidator {
    public boolean isValidName(String name){
        return name.matches("[a-zA-Z\\s'-]+");
    }
    public boolean isValidEmail(String email){
        String emailRegex = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    public boolean isValidSubject(String subject){
        String subjectRegex = "^(?=.*[A-Za-z])[A-Za-z0-9 ]+$";
        return subject.matches(subjectRegex);
    }
    public boolean isValidClassNumber(String clase){
        String classRegex = "^\\d+$";
        return clase.matches(classRegex);
    }
    public boolean isValidGrade(String grade){
        return grade.matches("^[0-9]+(\\.[0-9]+)?$");
    }

    }
