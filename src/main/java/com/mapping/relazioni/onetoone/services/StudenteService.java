package com.mapping.relazioni.onetoone.services;

import com.mapping.relazioni.onetoone.entities.Studente;
import com.mapping.relazioni.onetoone.repositories.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    public Studente addStudent(Studente studente){
       studenteRepository.save(studente);
        return studente;
    }

    public List<Studente> getAllStudents() {
        List<Studente> studenteList= studenteRepository.findAll();
        return studenteList;
    }

    public Optional<Studente> getStudent(Long id) {
        Optional<Studente> studenteOptional = studenteRepository.findById(id);
        return studenteOptional;
    }

    public Optional<Studente> updateStudent(Long id,Studente studente){
        Optional<Studente> studenteDaAggiornare = studenteRepository.findById(id);
        if (studenteDaAggiornare.isPresent()){
            studenteDaAggiornare.get().setNome(studente.getNome());
            studenteRepository.save(studenteDaAggiornare.get());
        } else {
            return Optional.empty();
        }
        return studenteDaAggiornare;
    }

    public Optional<Studente> deleteStudentById(Long id){
        Optional<Studente> studenteDaCancellareOptional = studenteRepository.findById(id);
        if(studenteDaCancellareOptional.isPresent()){
            studenteRepository.delete(studenteDaCancellareOptional.get());
            return studenteDaCancellareOptional;
        }else{
            return Optional.empty();
        }

    }

}
