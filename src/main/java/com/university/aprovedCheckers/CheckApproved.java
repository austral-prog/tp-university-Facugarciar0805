package com.university.aprovedCheckers;



import com.university.objetos.evaluations.Evaluations;

import java.util.List;

public interface CheckApproved {
    boolean checkApproved(List<Evaluations> exams, float nota);
}
