package com.mapping.relazioni.onetomany.repositories;

import com.mapping.relazioni.onetomany.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore,Long> {
}
