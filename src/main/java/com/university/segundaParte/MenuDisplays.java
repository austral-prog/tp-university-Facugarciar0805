package com.university.segundaParte;

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
        System.out.println("What do yo want to do with " + clase + " data: ");
        System.out.println("(1)-> Create new " + clase);
        System.out.println("(2)-> Read "+ clase + " data");
        System.out.println("(3)-> Update " + clase + " data");
        System.out.println("(4)-> Remove " + clase + " data");
        System.out.println("(5)-> Print "+clase+ " data");
        System.out.println("(6)-> Back to Menu");
        System.out.print("Enter your selection: ");
    }
    public void displayActionStudent(){
        System.out.println("What do yo want to do with Student data: ");
        System.out.println("(1)-> Create new Student");
        System.out.println("(2)-> Read Student data");
        System.out.println("(3)-> Update Student data");
        System.out.println("(4)-> Remove Student data");
        System.out.println("(5)-> Print Student data");
        System.out.println("(6)-> Asign Course to Student");
        System.out.println("(7)-> Asign Evaluation to Student");
        System.out.println("(8)-> Back to Menu");
        System.out.print("Enter your selection: ");
    }
    public void displayTypesOfEval(){
        System.out.println("Select the type of evaluation you want to create: ");
        System.out.println("(1) -> FINAL_PRACTICAL_WORK");
        System.out.println("(2) -> PRACTICAL_WORK");
        System.out.println("(3) -> WRITTEN_EXAM");
        System.out.println("(4) -> ORAL_EXAM");
        System.out.print("Enter your selection: ");
    }
}
