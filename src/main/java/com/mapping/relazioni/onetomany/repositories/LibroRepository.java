package com.mapping.relazioni.onetomany.repositories;

import com.mapping.relazioni.onetomany.entities.Libro;
import org.springdoc.core.providers.JavadocProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {

}
