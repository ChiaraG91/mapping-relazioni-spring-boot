package com.mapping.relazioni.onetoone.controllers;

import com.mapping.relazioni.onetoone.entities.Studente;
import com.mapping.relazioni.onetoone.services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studente")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("/addstudent")
    public ResponseEntity<Studente> addStudent(@RequestBody Studente studente){
        studenteService.addStudent(studente);
        return ResponseEntity.ok().body(studente);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<Studente>> getAllStudent(){
        List<Studente> allStudents =   studenteService.getAllStudents();
        return ResponseEntity.ok().body(allStudents);
    }

    @GetMapping("/getstudent/{id}")
    public ResponseEntity<Optional<Studente>> getStudent(@PathVariable Long id){
        Optional<Studente> studenteOptional = studenteService.getStudent(id);
        return ResponseEntity.ok().body(studenteOptional);
    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Studente> updateStudentById(@RequestBody Studente studente,@PathVariable Long id){
        Optional<Studente> studenteOptional = studenteService.updateStudent(id,studente);
        if(studenteOptional.isPresent()){
            return ResponseEntity.ok().body(studenteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteid")
    public ResponseEntity<Optional<Studente>> deleteStudentById(@RequestParam Long id){
        Optional<Studente> studenteDaCancellare = studenteService.deleteStudentById(id);
        if(studenteDaCancellare.isPresent()){
            return ResponseEntity.ok().body(studenteDaCancellare);
        }
        return ResponseEntity.notFound().build();

    }
}
