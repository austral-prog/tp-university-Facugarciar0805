package com.university;

public class MenuDisplays {
    public void displayInitialMenu(){
        System.out.println("Select the type the of data you want to work with: ");
        System.out.println("(1)-> Student");
        System.out.println("(2)-> Course");
        System.out.println("(3)-> Evaluation");
        System.out.println("(4)-> Exit Program");
        System.out.print("Enter your selection: ");
    }
    public void displayActionsMenu(String clase){
        System.out.println("Which of the following actions suits what you want to do with Students Data?:");
        System.out.println("(1)-> Create new " + clase);
        System.out.println("(2)-> Read "+ clase + " data");
        System.out.println("(3)-> Update " + clase + " data");
        System.out.println("(4)-> Remove " + clase + " data");
        System.out.println("(5)-> Back to Menu");
        System.out.print("Enter your selection: ");
    }
}
