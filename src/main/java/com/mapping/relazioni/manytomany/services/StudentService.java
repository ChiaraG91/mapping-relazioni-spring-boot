package com.mapping.relazioni.manytomany.services;

import com.mapping.relazioni.manytomany.entities.Student;
import com.mapping.relazioni.manytomany.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList= studentRepository.findAll();
        return studentList;
    }

    public Optional<Student> getStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional;
    }

    public Optional<Student> updateStudent(Long id,Student student){
        Optional<Student> studentDaAggiornare = studentRepository.findById(id);
        if (studentDaAggiornare.isPresent()){
            studentDaAggiornare.get().setNome(student.getNome());
            studentRepository.save(studentDaAggiornare.get());
        } else {
            return Optional.empty();
        }
        return studentDaAggiornare;
    }

    public Optional<Student> deleteStudentById(Long id){
        Optional<Student> studentDaCancellareOptional = studentRepository.findById(id);
        if(studentDaCancellareOptional.isPresent()){
            studentRepository.delete(studentDaCancellareOptional.get());
            return studentDaCancellareOptional;
        }else{
            return Optional.empty();
        }

    }
}
