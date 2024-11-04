package com.university.CLILogic.implementations;

import com.university.CLILogic.CRUDRepository;
import com.university.primeraParte.objetos.evaluations.Evaluations;

import java.util.HashMap;

public class CrudRepoEvaluation implements CRUDRepository<Evaluations> {
    private HashMap<Integer, Evaluations> evaluations;

    public CrudRepoEvaluation(){
        this.evaluations= new HashMap<>();
    }
    @Override
    public void create(Evaluations entity) {
        if(!evaluations.containsKey(entity.getId())){
            evaluations.put(entity.getId(), entity);
        }
    }

    @Override
    public Evaluations read(int id) {
        if(evaluations.containsKey(id)){
            return evaluations.get(id);
        }
        return null;
    }

    @Override
    public void update(int id, Evaluations entity) {
        if(evaluations.containsKey(id)){
            evaluations.get(id).setSubject(entity.getSubject());
            evaluations.get(id).setEvaluationName(entity.getEvaluationName());
            evaluations.get(id).setEvaluationType(entity.getEvaluationType());
        }



    }

    @Override
    public void delete(int id) {
       evaluations.remove(id);
    }

    @Override
    public String getIdentifier() {
        return "Evaluation";
    }

    @Override
    public Class<Evaluations> getEntityClass() {
        return Evaluations.class;
    }
}
