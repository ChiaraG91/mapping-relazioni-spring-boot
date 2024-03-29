package com.mapping.relazioni.manytomany.repositories;

import com.mapping.relazioni.manytomany.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
