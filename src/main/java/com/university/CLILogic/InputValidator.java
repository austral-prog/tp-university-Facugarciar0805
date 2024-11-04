package com.university.CLILogic;

public class InputValidator {
    public boolean isValidName(String name){
        return name.matches("[a-zA-Z\\s'-]+");
    }
    public boolean isValidEmail(String email){
        String emailRegex = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}
