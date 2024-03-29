package com.mapping.relazioni.manytomany.controllers;

import com.mapping.relazioni.manytomany.entities.Student;
import com.mapping.relazioni.manytomany.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudents =   studentService.getAllStudents();
        return ResponseEntity.ok().body(allStudents);
    }

    @GetMapping("/getstudent/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long id){
        Optional<Student> studentOptional = studentService.getStudent(id);
        return ResponseEntity.ok().body(studentOptional);
    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student student,@PathVariable Long id){
        Optional<Student> studentOptional = studentService.updateStudent(id,student);
        if(studentOptional.isPresent()){
            return ResponseEntity.ok().body(studentOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteid")
    public ResponseEntity<Optional<Student>> deleteStudentById(@RequestParam Long id){
        Optional<Student> studentDaCancellare = studentService.deleteStudentById(id);
        if(studentDaCancellare.isPresent()){
            return ResponseEntity.ok().body(studentDaCancellare);
        }
        return ResponseEntity.notFound().build();

    }
}
