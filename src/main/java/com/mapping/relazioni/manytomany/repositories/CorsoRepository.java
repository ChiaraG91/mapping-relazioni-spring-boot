package com.mapping.relazioni.manytomany.repositories;

import com.mapping.relazioni.manytomany.entities.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsoRepository extends JpaRepository<Corso,Long> {
}
