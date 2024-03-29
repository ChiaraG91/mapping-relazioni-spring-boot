package com.mapping.relazioni.onetoone.repositories;

import com.mapping.relazioni.onetoone.entities.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Studente,Long> {
}
