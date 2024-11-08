package com.university.segundaParte.CLILogic.implementations;

import com.university.segundaParte.CLILogic.flowActionEntities.AlreadyExists;
import com.university.primeraParte.objetos.Course;
import com.university.primeraParte.objetos.Student;
import com.university.primeraParte.objetos.evaluations.Evaluations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudRepoStudent implements CRUDRepository<Student> {
    private HashMap<Integer, Student> students;
    public CrudRepoStudent(){
        this.students = new HashMap<>();
    }
    @Override
    public void create(Student entity) {
        if(!students.containsKey(entity.getId())){
            students.put(entity.getId(),entity);
        }
    }

    @Override
    public Student read(int id) {
        if(students.containsKey(id)){
            return students.get(id);
        }
        else{
            return null;
        }
    }

    @Override
    public void update(int id, Student entity) {
        if(students.containsKey(id)){
            students.get(id).setName(entity.getName());
            students.get(id).setMail(entity.getMail());
        }

    }
    @Override
    public void delete(int id) {
        students.remove(id);
    }

    @Override
    public String getIdentifier() {
        return "Student";
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public void printEntity() {
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            System.out.println("ID: "+entry.getKey()+", Student: " + entry.getValue().getName() + ", " + entry.getValue().getMail());
        }
    }
    public HashMap<Integer, Student> getEntity(){
        return students;
    }
    public void asignToCourse(Student student, Course course) throws AlreadyExists {
        List<Course> cousesList = student.getCourses();
        boolean found = false;
        for(Course course1: cousesList){
            if(course1.equals(course)){
                found=true;
            }
        }
        if(!found){
            student.addCourse(course);
            course.addStudent(student);
        }
        else{
            throw new AlreadyExists();

        }

    }
    public void asignToEvaluation(Student student, Evaluations evaluations){
        List<Evaluations> evaluationsList = student.getEvaluations();
        boolean found = false;
        for(Evaluations evaluations1: evaluationsList){
            if(evaluations1.equals(evaluations)){
                found=true;
            }
        }
        if(!found){
            student.addEval(evaluations);
        }
        else{
            throw new AlreadyExists();

        }
    }
}
