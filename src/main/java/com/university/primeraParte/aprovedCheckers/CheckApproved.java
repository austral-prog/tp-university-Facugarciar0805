package com.university.primeraParte.aprovedCheckers;



import com.university.primeraParte.objetos.evaluations.Evaluations;

import java.util.List;

public interface CheckApproved {
    boolean checkApproved(List<Evaluations> exams, float nota);
}
