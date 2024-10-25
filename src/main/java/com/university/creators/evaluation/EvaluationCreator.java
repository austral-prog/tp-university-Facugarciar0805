package com.university.creators.evaluation;

import com.university.objetos.evaluations.Evaluations;
import com.university.objetos.evaluations.Final;
import com.university.objetos.evaluations.Parcial;
import com.university.objetos.evaluations.TrabajoPractico;
import com.university.objetos.student.Student;

public class EvaluationCreator {
    TrabajoPracticoCreator trabajoPracticoCreator;
    FinalCreator finalCreator;
    ParcialCreator parcialCreator;
    public EvaluationCreator(){
        this.trabajoPracticoCreator = new TrabajoPracticoCreator();
        this.finalCreator = new FinalCreator();
        this.parcialCreator = new ParcialCreator();
    }

    public Evaluations createEvaluations(Student s, String[] linea){
        if(linea[3].contains("Parcial")){
            Parcial parcial = parcialCreator.createObject(s.getParciales(),linea);
            return parcial;
        } else if (linea[3].contains("TP")) {
            TrabajoPractico tp = trabajoPracticoCreator.createObject(s.getTps(),linea);
            return tp;
        }else{
            Final final1 = finalCreator.createObject(s.getFinales(),linea);
            return final1;
        }
    }


}
