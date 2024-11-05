package com.university.CLILogic.flowActionEntities;

public interface FlowActionInterface {
    boolean act();
    void create();
    void read();
    void update();
    void delete();
    boolean askForAnotherAction();
    void printData();

}
